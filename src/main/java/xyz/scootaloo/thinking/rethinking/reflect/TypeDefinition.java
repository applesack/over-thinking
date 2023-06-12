package xyz.scootaloo.thinking.rethinking.reflect;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/06/09
 */
public interface TypeDefinition {

    int mark();

    boolean isGeneric();

    boolean isArray();

    boolean hasProperties();

    Iterator<Property> getProperties();

    Class<?> getRawType();

    GenericTypeDefinition getGenericType();

    Object newInstance();

    String toString();

    static Object safeNewInstance(Factory factory) {
        try {
            return factory.get();
        } catch (Throwable e) {
            return null;
        }
    }

    static Object unsafeNewInstance(Factory factory) {
        try {
            return factory.get();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    interface Property {
        String name();

        void set(Object owner, Object value);

        Object get(Object owner);

        List<Property> EMPTY_PROPERTIES = Collections.emptyList();
    }

    @FunctionalInterface
    interface Factory {
        Object get() throws Throwable;
    }
}
