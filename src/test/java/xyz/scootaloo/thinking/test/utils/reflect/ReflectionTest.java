package xyz.scootaloo.thinking.test.utils.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author AppleSack
 * @since 2023/06/05
 */
public class ReflectionTest {

    @Test
    public void testTypeMembers() {
        handle(Type1.class, null);
    }

    @Test
    public void testTypeMembers2() {
        handle(GenericPojo.class, null);
    }

    private void handle(Class<?> classType, Type[] typeGenericArgs) {

    }

    private Mapper mapper(Class<?> classType, Type[] genericTypeParameters) {
        var typeParameters = classType.getTypeParameters();
        assertGenericInfoConsistent(classType, typeParameters, genericTypeParameters);

        Constructor<?> nonArgConstructor = null;
        for (var constructor : classType.getDeclaredConstructors()) {
            if (constructor.getParameterCount() == 0) {
                constructor.setAccessible(true);
                nonArgConstructor = constructor;
                break;
            }
        }
        if (nonArgConstructor == null) {
            throw new IllegalArgumentException(
                    String.format("non arg constructor not found: %s", classType.getName()));
        }

        var fields = classType.getDeclaredFields();
        var properties = new HashMap<String, Property>();
        for (var field : fields) {
            var genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType parameterGenericType)) {
                continue;
            }
            var arguments = parameterGenericType.getActualTypeArguments();
            var fieldName = field.getName();

        }

        return new Mapper(classType, genericTypeParameters, properties, nonArgConstructor);
    }

    private void assertGenericInfoConsistent(
            Class<?> classType, Type[] typeParameters, Type[] genericTypeParameters) {
        var sourceSize = typeParameters == null ? 0 : typeParameters.length;
        var inputSize = genericTypeParameters == null ? 0 : genericTypeParameters.length;
        if (sourceSize != inputSize) {
            throw new IllegalArgumentException(
                    String.format("generic parameter list is inconsistent: %s", classType.getName()));
        }
    }

    private record Mapper(
            Class<?> type, Type[] genericActualArguments,
            Map<String, Property> properties, Constructor<?> constructor
    ) {
        public Object createInstanceWithArg(Object arg) throws InvocationTargetException,
                                                               InstantiationException,
                                                               IllegalAccessException {
            var instance = constructor.newInstance();
            var arguments = argMap(arg);
            if (arguments.isEmpty()) {
                return instance;
            }

            properties.forEach((fieldName, property) -> {
                var value = arguments.get(fieldName);
                if (value == null) {
                    return;
                }


            });
            return instance;
        }

        public boolean setField(Object owner, Property property, Object value) {
            return true;
        }

        @SuppressWarnings({ "unchecked" })
        private Map<String, Object> argMap(Object arg) {
            if (arg == null) {
                return Collections.emptyMap();
            }
            if (arg instanceof Map<?, ?>) {
                return (Map<String, Object>) arg;
            } else {
                throw new IllegalArgumentException(String.format("%s type must be Map<String, Any>", arg));
            }
        }
    }

    private record Property(String name, Field field, Mapper mapper) {
    }

    private static class Type0 {
        private int     member0; // 基础类型
        private Integer member1; // 基本类型，包装类
        private String  member2; // 基本类型，应用类型
        private Pojo0   member3; // 引用类型1
        private Pojo1   member4; // 引用类型2
        private Pojo2   member5; // 引用类型3，复杂类型组合
    }

    private static class Type1 {
        private List<Integer>                  member0; // 集合0，列表
        private ArrayList<Integer>             member1; // 集合1，ArrayList
        private Map<String, List<List<Float>>> member3; // 集合3，复杂类型
    }

    // 无成员变量pojo
    private static class Pojo0 {
    }

    // 包含两个基本类型成员变量的pojo
    private static class Pojo1 {
        private int    age;
        private String name;
    }

    // 包含复合类型的pojo
    private static class Pojo2 {
        private int                age;
        private List<Pojo1>        list0;
        private Map<String, Pojo1> map0;
    }

    private static class GenericPojo<T> {
        private T value;
    }
}
