package xyz.scootaloo.thinking.rethinking.httpserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static xyz.scootaloo.thinking.rethinking.httpserver.ResponseHeaderBuilder.*;

/**
 * @author AppleSack
 * @since 2023/04/21
 */
public class RequestHandler implements Runnable {

    private static final DateFormat formatter = new SimpleDateFormat(
            "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);

    static {
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    private static final Logger log = LoggerFactory.getLogger("req-hande");

    private final NioHttpServer server;
    private final String        serverRoot;
    private final SoftCache     cache;

    private String acceptEncoding;
    private File   currentFile;
    private Date   lastModified;

    private final List<RequestSegmentHeader>               pendingRequestSegment = new ArrayList<>();
    private final Map<SocketChannel, RequestHeaderDecoder> requestMap            = new WeakHashMap<>();

    public RequestHandler(NioHttpServer server, String wwwroot, SoftCache cache) {
        this.cache = cache;
        this.serverRoot = wwwroot;
        this.server = server;
    }

    @Override
    public void run() {
        RequestSegmentHeader requestData;
        RequestHeaderDecoder header;
        ResponseHeaderBuilder respBuilder = new ResponseHeaderBuilder();
        byte[] head, body = new byte[0];
        String file = null, mine;
        boolean zip;

        while (true) {
            synchronized (pendingRequestSegment) {
                while (pendingRequestSegment.isEmpty()) {
                    try {
                        pendingRequestSegment.wait();
                    } catch (InterruptedException ignore) {
                    }
                }
                requestData = pendingRequestSegment.remove(0);
            }

            header = requestMap.computeIfAbsent(requestData.client, k -> new RequestHeaderDecoder());
            try {
                if (header.appendSegment(requestData.data)) {
                    file = serverRoot + header.getResource();
                    currentFile = new File(file);
                    mine = Utils.getContentType(currentFile);
                    acceptEncoding = header.getHeader(ACCEPT_ENCODING);
                    zip = mine.contains("text") && acceptEncoding != null
                            && acceptEncoding.contains("gzip");
                    respBuilder.clear();

                    respBuilder.addHeader(CONNECTION, KEEP_ALIVE);
                    respBuilder.addHeader(CONTENT_TYPE, mine);

                    body = Utils.file2ByteArray(currentFile, zip);
                    respBuilder.addHeader(CONNECTION, body.length);
                    if (zip) {
                        respBuilder.addHeader(CONTENT_LENGTH, GZIP);
                    }

                    lastModified = new Date(currentFile.lastModified());
                    respBuilder.addHeader(LAST_MODIFIED, formatter.format(lastModified));

                    head = respBuilder.getHeader();
                    server.send(requestData.client, head);
                    if (body != null && header.getVerb() == RequestHeaderDecoder.Verb.GET)
                        server.send(requestData.client, body);

                    log.info(header.getResource() + " 200");
                }
            } catch (IOException e) {
                respBuilder.addHeader(CONTENT_LENGTH, 0);
                respBuilder.setStatus(NOT_FOUND_404);
                head = respBuilder.getHeader();
                server.send(requestData.client, head);
                // cache 404 if case client make a mistake again
                cache.put(file, head, body);
                log.error(header.getResource() + " 404");

            } catch (Exception e) {
                // any other, it's a 505 error
                respBuilder.addHeader(CONTENT_LENGTH, 0);
                respBuilder.setStatus(SERVER_ERROR_500);
                head = respBuilder.getHeader();
                server.send(requestData.client, head);
                log.error("505 error", e);
            }
        }
    }

    public void processData(SocketChannel client, byte[] data, int count) {
        byte[] dataCopy = new byte[count];
        System.arraycopy(data, 0, dataCopy, 0, count);

        synchronized (pendingRequestSegment) {
            // add data
            pendingRequestSegment
                    .add(new RequestSegmentHeader(client, dataCopy));
            pendingRequestSegment.notify();
        }
    }

    private record RequestSegmentHeader(SocketChannel client, byte[] data) {
    }
}
