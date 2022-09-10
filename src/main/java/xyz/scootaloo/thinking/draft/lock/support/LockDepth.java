package xyz.scootaloo.thinking.draft.lock.support;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 14:48
 */
public class LockDepth {

    private final boolean isInfinity;

    @Contract(pure = true)
    public LockDepth(@NotNull String pattern) {
        this.isInfinity = pattern.contains("y");
    }

    public boolean isInfinity() {
        return isInfinity;
    }

}
