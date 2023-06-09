package xyz.scootaloo.thinking.rethinking.reflect;

/**
 * @author AppleSack
 * @since 2023/06/09
 */
public interface TypeDefinition {

    int mark();

    boolean isGeneric();

    Class<?> getRawType();

    GenericTypeDefinition getGenericType();

    String toString();
}
