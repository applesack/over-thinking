package xyz.scootaloo.thinking.rethinking.httpserver;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author AppleSack
 * @since 2023/04/21
 */
public class ResponseHeaderBuilder {

    public static final String OK_200           = "HTTP/1.1 200 OK";
    public static final String NEWLINE          = "\r\n";
    public static final String NOT_FOUND_404    = "HTTP/1.1 404 Not Find";
    public static final String SERVER_ERROR_500 = "HTTP/1.1 500 Internal Server Error";
    public static final String CONTENT_TYPE     = "Content-Type";
    public static final String CONNECTION       = "Connection";
    public static final String CONTENT_LENGTH   = "Content-Length";
    public static final String KEEP_ALIVE       = "keep-alive";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String ACCEPT_ENCODING  = "Accept-Encoding";
    public static final String LAST_MODIFIED    = "Last-Modified";
    public static final String GZIP             = "gzip";

    private String              status;
    private Map<String, Object> header = new TreeMap<>();

    public ResponseHeaderBuilder() {
        status = OK_200;
    }

    public ResponseHeaderBuilder addHeader(String key, Object value) {
        header.put(key, value);
        return this;
    }

    public void clear() {
        status = OK_200;
        header.clear();
    }

    public byte[] getHeader() {
        return toString().getBytes();
    }

    public ResponseHeaderBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(120);
        builder.append(status).append(NEWLINE);
        Set<String> keySet = header.keySet();
        for (String key : keySet) {
            builder.append(key).append(": ").append(header.get(key)).append(NEWLINE);
        }
        builder.append(NEWLINE);
        return builder.toString();
    }
}
