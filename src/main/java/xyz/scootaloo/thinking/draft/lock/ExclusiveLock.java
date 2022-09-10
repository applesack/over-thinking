package xyz.scootaloo.thinking.draft.lock;

import xyz.scootaloo.thinking.draft.lock.support.LockDepth;
import xyz.scootaloo.thinking.draft.lock.support.TimeoutInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 10:21
 */
public class ExclusiveLock extends BaseLock {

    private String token;
    private final LockDepth depth;
    private final TimeoutInfo timeout;
    private final List<String> owner;

    public ExclusiveLock(String owner, LockDepth depth, TimeoutInfo timeout) {
        this.depth = depth;
        this.timeout = timeout;
        this.owner = new ArrayList<>(1);
        this.owner.add(owner);
    }

    @Override
    public LockDepth depth() {
        return this.depth;
    }

    @Override
    public String token() {
        return this.token;
    }

    @Override
    public Collection<String> owner() {
        return this.owner;
    }

    @Override
    public void refreshToken() {
        this.token = generateToken();
    }

    @Override
    public TimeoutInfo timeout() {
        return timeout;
    }

    @Override
    public String type() {
        return "exclusive";
    }

}
