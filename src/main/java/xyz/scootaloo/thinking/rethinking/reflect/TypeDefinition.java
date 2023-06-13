package xyz.scootaloo.thinking.rethinking.reflect;

import xyz.scootaloo.thinking.rethinking.reflect.Deconstruction.GenericTypeDefinition;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static xyz.scootaloo.thinking.rethinking.reflect.Deconstruction.*;

/**
 * @author AppleSack
 * @since 2023/06/09
 */
public sealed interface TypeDefinition
        permits ArrayTypeDefinition,
                GenericTypeDefinition,
                NormalTypeDefinition {

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
