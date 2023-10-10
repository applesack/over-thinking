package xyz.scootaloo.thinking.rethinking.eventloop;

/**
 * @author AppleSack
 * @since 2023/10/10
 */
public final class Event {
    public final String key;
    public final Object data;

    public Event(String key, Object data) {
        this.key = key;
        this.data = data;
    }
}
