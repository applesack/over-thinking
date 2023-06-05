package xyz.scootaloo.thinking.utils.reflect;

/**
 * @author AppleSack
 * @since 2023/06/04
 */
public interface TypeInstance {

    TypeTemplate template();

    void setField(String fieldName, Object value);

    Object getField(String fieldName);

    Object getInstance();
}
