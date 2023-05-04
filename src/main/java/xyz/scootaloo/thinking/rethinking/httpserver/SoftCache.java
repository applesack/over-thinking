package xyz.scootaloo.thinking.rethinking.httpserver;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author AppleSack
 * @since 2023/04/21
 */
public class SoftCache {

    public record CacheEntry(byte[] header, byte[] body) {
    }

    public static class MapEntry extends SoftReference<CacheEntry> {
        final String key;

        public MapEntry(String key, CacheEntry referent, ReferenceQueue<? super CacheEntry> q) {
            super(referent, q);
            this.key = key;
        }
    }

    private final ReferenceQueue<CacheEntry> queue = new ReferenceQueue<>();

    private Map<String, MapEntry> map = new ConcurrentHashMap<>();

    public CacheEntry get(String key) {
        CacheEntry result = null;
        MapEntry entry = map.get(key);
        if (entry != null) {
            result = entry.get();
            if (result == null) {
                map.remove(entry.key);
            }
        }
        return result;
    }

    public void put(String key, byte[] header, byte[] body) {
        processQueue();
        map.put(key, new MapEntry(key, new CacheEntry(header, body), queue));
    }

    private void processQueue() {
        MapEntry entry;
        while ((entry = (MapEntry) queue.poll()) != null) {
            map.remove(entry.key);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int memory = 0;
        for (String key : map.keySet()) {
            CacheEntry entry = map.get(key).get();
            if (entry == null) {
                continue;
            }
            int size = 0;
            if (entry.header != null) {
                size += entry.header.length;
            }
            if (entry.body != null) {
                size += entry.body.length;
            }
            builder.append(key).append("\t").append(size).append("\t").append(size / 1024).append("k\n");
            memory += size;
        }
        return "cache item count: " +
                map.size() + "\n" +
                "memory size:\t" +
                (double) memory / 1024 + "k\n" +
                builder;
    }
}
