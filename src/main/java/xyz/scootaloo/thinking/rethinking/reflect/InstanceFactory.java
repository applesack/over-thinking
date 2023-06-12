package xyz.scootaloo.thinking.rethinking.reflect;

/**
 * @author AppleSack
 * @since 2023/06/09
 */
public interface InstanceFactory {

    void registerStructure(String qualifiedName, TypeDefinition definition);

    TypeDefinition getDefinition(String qualifiedName);

    <T> T getInstance(Class<T> type, Object arg);

}
