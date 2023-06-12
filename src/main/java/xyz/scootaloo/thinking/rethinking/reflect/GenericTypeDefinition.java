package xyz.scootaloo.thinking.rethinking.reflect;

import java.util.Iterator;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/06/09
 */
public record GenericTypeDefinition(
        Class<?> rawType, List<TypeDefinition> actualTyeArguments, int mark
) implements TypeDefinition {

    @Override
    public boolean isGeneric() {
        return true;
    }

    @Override
    public boolean isArray() {
        return false;
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
        return rawType;
    }

    @Override
    public GenericTypeDefinition getGenericType() {
        return this;
    }

    @Override
    public Object newInstance() {
        return null;
    }
}
