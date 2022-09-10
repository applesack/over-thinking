package xyz.scootaloo.thinking.draft.lock;

import xyz.scootaloo.thinking.draft.lock.impl.LockSupportImpl;
import xyz.scootaloo.thinking.draft.lock.support.LockToken;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 9:55
 */
public abstract class LockSupport {

    private static final Object lock = new Object();

    private static volatile LockSupport lockSupport;

    protected final Config config = new Config();

    public static LockSupport getInstance() {
        LockSupport ins = lockSupport;
        if (ins == null) {
            synchronized (lock) {
                if (lockSupport == null) {
                    lockSupport = new LockSupportImpl();
                }
                ins = lockSupport;
            }
        }
        return ins;
    }

    public Config config() {
        return config;
    }

    public abstract LockResult lock(String path, String owner, LockToken pass);

    public abstract LockResult unlock(String path, BaseLock lock);

    public abstract void timeoutRecycle(long currentTimeMillis);

    public static class Config {

        protected long lowerLimit = 5 * 1000;
        protected long upperLimit = 30 * 1000;

        public Config setTimeoutLowerLimit(long lower) {
            this.lowerLimit = lower;
            return this;
        }

        public Config setTimeoutUpperLimit(long upper) {
            this.upperLimit = upper;
            return this;
        }

    }

}
