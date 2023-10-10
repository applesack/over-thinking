package xyz.scootaloo.thinking.rethinking.eventloop;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;

/**
 * @author AppleSack
 * @since 2023/10/10
 */
public final class EventLoop {

    private final ConcurrentLinkedDeque<Event> events = new ConcurrentLinkedDeque<>();

    private final ConcurrentHashMap<String, Consumer<Object>> handlers = new ConcurrentHashMap<>();

    public EventLoop on(String key, Consumer<Object> handler) {
        handlers.put(key, handler);
        return this;
    }

    public void dispatch(Event event) {
        events.add(event);
    }

    public void stop() {
        Thread.currentThread().interrupt();
    }

    public void run() {
        while (!(events.isEmpty() && Thread.interrupted())) {
            if (events.isEmpty()) {
                continue;
            }
            Event event = events.pop();
            if (handlers.containsKey(event.key)) {
                handlers.get(event.key).accept(event.data);
            } else {
                System.out.println("No handler for key " + event.key);
            }
        }
    }
}
