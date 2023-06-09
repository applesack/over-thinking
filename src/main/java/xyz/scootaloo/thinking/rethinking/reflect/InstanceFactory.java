package xyz.scootaloo.thinking.rethinking.reflect;

/**
 * @author AppleSack
 * @since 2023/06/09
 */
public @FunctionalInterface interface InstanceFactory {

    <T> T getInstance(Class<T> type, Object arg);

}
