package xyz.scootaloo.thinking.utils.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/06/04
 */
public class ObjectMapping implements TypeTemplate {

    private final Class<?> type;
    private final String   qualifiedName;

    private final Map<String, Field>   members      = new HashMap<>();
    private final List<Constructor<?>> constructors = new ArrayList<>();

    public ObjectMapping(Class<?> type) {
        this.type = type;
        this.qualifiedName = type.getName();
        initialize();
    }

    @Override
    public Class<?> type() {
        return type;
    }

    @Override
    public String qualifiedName() {
        return qualifiedName;
    }

    @Override
    public TypeInstance construct(List<Object> args) {
        return null;
    }

    private void initialize() {
        for (Field field : type.getDeclaredFields()) {
            String fieldName = field.getName();
            field.setAccessible(true);
            members.put(fieldName, field);
        }

        for (Constructor<?> constructor : type.getConstructors()) {
            constructor.setAccessible(true);
            this.constructors.add(constructor);
        }
    }

    private Constructor<?> matchConstructor(List<Object> args) {
        if (args == null || args.isEmpty()) {
            return findNonArgConstructor();
        }

        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
        }
        return null;
    }

    private Constructor<?> findNonArgConstructor() {
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                return constructor;
            }
        }
        throw new IllegalArgumentException(String.format("%s hasn't no arg constructor", qualifiedName));
    }

    private record ObjectInstance(TypeTemplate template, Object instance) {
    }
}
