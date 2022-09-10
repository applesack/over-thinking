package xyz.scootaloo.thinking.draft.lock.impl;

import org.jetbrains.annotations.Nullable;
import xyz.scootaloo.thinking.draft.lock.BaseLock;
import xyz.scootaloo.thinking.draft.lock.LockResult;
import xyz.scootaloo.thinking.draft.lock.LockSupport;
import xyz.scootaloo.thinking.draft.lock.support.LockToken;
import xyz.scootaloo.thinking.draft.lock.support.Node;

import java.util.TreeMap;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 10:35
 */
public class LockSupportImpl extends LockSupport {

    private final TreeMap<Long, Object> timeout = new TreeMap<>();
    private final Node root = new Node("/", null);

    @Override
    public LockResult lock(String path, String owner, LockToken pass) {

        return null;
    }

    @Override
    public LockResult unlock(String path, BaseLock lock) {
        return null;
    }

    @Override
    public void timeoutRecycle(long currentTimeMillis) {

    }

    private @Nullable LockResult select(String path, LockToken token) {
        return null;
    }

}
