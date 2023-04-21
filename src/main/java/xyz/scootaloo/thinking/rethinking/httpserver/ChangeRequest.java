package xyz.scootaloo.thinking.rethinking.httpserver;

import java.nio.channels.SocketChannel;

/**
 * @author AppleSack
 * @since 2023/04/21
 */
public record ChangeRequest(SocketChannel socket, int type, int ops) {
    public static final int REGISTER   = 1;
    public static final int CHANGE_OPS = 2;
}
