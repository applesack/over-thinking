package xyz.scootaloo.thinking.rethinking.httpserver;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author AppleSack
 * @since 2023/04/21
 */
public class RequestHeaderDecoder {

    public enum Verb {
        CONNECT, DELETE, GET, HEAD, OPTIONS, PATCH, POST, PUT, TRACE
    }

    public enum Version {
        HTTP10, HTTP11
    }

    private static       CharsetDecoder decoder = StandardCharsets.ISO_8859_1.newDecoder();
    private static final byte[]         END     = { 13, 10, 13, 10 };
    private static final byte[]         GET     = { 71, 69, 84, 32 };
    private static final byte[]         HEAD    = { 72, 69, 65, 68 };

    private boolean begin  = false;

    private CharBuffer charBuffer = ByteBuffer.allocate(2048).asCharBuffer();
    private Map<String, String> headerMap = new TreeMap<>();

    private String resource;
    private Verb verb;

    public boolean appendSegment(byte[] segment) {
        int beginIndex = 0;
        if (!begin) {
            if ((beginIndex = Utils.subArray(segment, GET, 0)) != segment.length) {
                begin = true;
                headerMap.clear();
                verb = Verb.GET;
            } else if ((beginIndex = Utils.subArray(segment, HEAD, 0)) != segment.length) {
                begin = true;
                headerMap.clear();
                verb = Verb.HEAD;
            } else {
                return false;
            }
        }

        int endIndex = Utils.subArrayFromEnd(segment, END);
        ByteBuffer buffer = ByteBuffer.wrap(segment, beginIndex, endIndex);
        decoder.decode(buffer, charBuffer, endIndex != segment.length);
        if (endIndex != segment.length) {
            extractValueAndReset();
            return true;
        }
        return false;
    }

    public String getHeader(String key) {
        return headerMap.get(key);
    }

    public String getResource() {
        return resource;
    }

    public Verb getVerb() {
        return verb;
    }

    private void extractValueAndReset() {
        charBuffer.flip();
        String head = charBuffer.toString();
        String[] lines = head.split("\r\n");
        String[] split = lines[0].split(" ");

        resource = split[1];

        for (int i = 1; i<lines.length; ++i) {
            String[] temp = lines[i].split(":");
            headerMap.put(temp[0].trim(), temp[1].trim());
        }

        charBuffer.clear();
        decoder.reset();
        begin = false;
    }
}
