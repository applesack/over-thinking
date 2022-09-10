package xyz.scootaloo.thinking.draft.lock;

import org.jetbrains.annotations.NotNull;
import xyz.scootaloo.thinking.draft.lock.support.LockDepth;
import xyz.scootaloo.thinking.draft.lock.support.TimeoutInfo;

import java.util.Collection;
import java.util.UUID;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 10:19
 */
public abstract class BaseLock {

    private static final String TOKEN_PREFIX = "urn:uuid:";

    public abstract LockDepth depth();

    public abstract String token();

    public abstract Collection<String> owner();

    public abstract void refreshToken();

    public abstract TimeoutInfo timeout();

    public abstract String type();

    protected @NotNull String generateToken() {
        return TOKEN_PREFIX + UUID.randomUUID();
    }

}
