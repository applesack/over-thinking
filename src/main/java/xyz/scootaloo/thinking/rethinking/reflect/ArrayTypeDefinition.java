package xyz.scootaloo.thinking.rethinking.reflect;

import java.util.Iterator;

/**
 * @author AppleSack
 * @since 2023/06/10
 */
public record ArrayTypeDefinition(
        TypeDefinition definition
) implements TypeDefinition {

    @Override
    public int mark() {
        return 0;
    }

    @Override
    public boolean isGeneric() {
        return false;
    }

    @Override
    public boolean isArray() {
        return true;
    }

    @Override
    public boolean hasProperties() {
        return false;
    }

    @Override
    public Iterator<Property> getProperties() {
        return null;
    }

    @Override
    public Class<?> getRawType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public GenericTypeDefinition getGenericType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object newInstance() {
        return null;
    }
}
