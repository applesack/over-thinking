package xyz.scootaloo.thinking.test.utils.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

/**
 * @author AppleSack
 * @since 2023/06/05
 */
public class ReflectionTest {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Test
    public void testTypeMembers() {
        handle(Type1.class, null);
    }

    @Test
    public void testTypeMembers2() {
        handle(GenericPojo.class, null);
    }

    @Test
    public void testGenerateGName() {
        var classType = Type1.class;
        tPrintGNameByField(Utils.getFiled(classType, "member0"));
        tPrintGNameByField(Utils.getFiled(classType, "member1"));
        tPrintGNameByField(Utils.getFiled(classType, "member2"));
    }

    private void tPrintGNameByField(Field field) {
        var fieldType = field.getType();
        var typeParameter = field.getGenericType();
        if (typeParameter instanceof ParameterizedType parameterGenericType) {
            var actualTypeArguments = parameterGenericType.getActualTypeArguments();
            var qualifiedName = getQualifiedName(fieldType, actualTypeArguments);
            System.out.println(qualifiedName);
        }
    }

    private void handle(Class<?> classType, Type[] typeGenericArgs) {

    }

    private ObjectMapper getMapper(Class<?> classType, Type[] genericTypeParameters) {
        return null;
    }

    private ObjectMapper getMapperCore(Class<?> classType, Type[] genericTypeParameters) {
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
            var fieldType = field.getType();
            var fieldName = field.getName();
            var property = new Property(fieldName, field, getMapper(fieldType, arguments));
            properties.put(fieldName, property);
        }

//        return new ObjectMapper(classType, genericTypeParameters, properties, nonArgConstructor);
        return null;
    }

    private String getQualifiedName(Class<?> classType, Type[] genericTypeParameters) {
        int gTypeSize = genericTypeParameters == null ? 0 : genericTypeParameters.length;
        if (gTypeSize == 0) {
            return classType.getTypeName();
        }
        return classType.getTypeName() + genericTypeDescription(genericTypeParameters);
    }

    private String genericTypeDescription(Type[] genericTypeParameters) {
        var parameterList = Arrays.stream(genericTypeParameters)
                .map(this::genericTypeDescription)
                .collect(Collectors.joining(","));
        return "<" + parameterList + ">";
    }

    private String genericTypeDescription(Type genericTypeParameter) {
        if (genericTypeParameter instanceof ParameterizedType parameterizedType) {
            // 举例:
            // 如果是List<String>, rawType=List, actualTypeArguments=[String]
            // 如果是Map<String,List<String>, actualTypeArguments=[String,List<String>]
            var rawType = parameterizedType.getRawType();
            var actualTypeArguments = parameterizedType.getActualTypeArguments();
            return normalTypeDescription((Class<?>) rawType) + genericTypeDescription(actualTypeArguments);
        }
        return normalTypeDescription((Class<?>) genericTypeParameter);
    }

    private String normalTypeDescription(Class<?> normalType) {
        return normalType.getTypeName();
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

    private static class TypeMark {
        /* 对象类型 */
        static final int object = 0;

        /* [1,10] 基本类型 */
        static final int t_bool   = 1;
        static final int t_byte   = 2;
        static final int t_short  = 3;
        static final int t_int    = 4;
        static final int t_float  = 5;
        static final int t_double = 6;
        static final int t_long   = 7;
        static final int t_string = 8;

        /* [11,20] 包装类型 */
        static final int w_bool   = 11;
        static final int w_byte   = 12;
        static final int w_short  = 13;
        static final int w_int    = 14;
        static final int w_float  = 15;
        static final int w_double = 16;
        static final int w_long   = 17;

        /* 集合类型 */
        static final int ls             = 20;
        static final int ls_array_list  = 21;
        static final int ls_linked_list = 22;

        static final int que       = 30;
        static final int que_deque = 31;
        static final int que_pq    = 32;

        static final int set      = 40;
        static final int set_hash = 41;
        static final int set_tree = 42;

        static final int map      = 50;
        static final int map_hash = 51;
        static final int map_tree = 52;
    }

    private @FunctionalInterface interface IConstructor {
        Object createInstance();
    }

    private record ObjectMapper(
            IConstructor constructor, TypeDefinition definition
    ) {
    }

    private record Property(String name, Field field, ObjectMapper objectMapper) {
    }

    private interface TypeDefinition {

        boolean isGeneric();

        Class<?> getType();

        GenericTypeDefinition getGenericType();

        static TypeDefinition resolveTypeDefinition(Class<?> rawType, Type[] actualTypeParameters) {
            // todo 检查 rawType 是否有泛型参数
            if (actualTypeParameters == null) {
                return new NormalTypeDefinition(rawType);
            }
            var actualTypeArguments = new ArrayList<TypeDefinition>(actualTypeParameters.length);
            for (Type actualTypeParameter : actualTypeParameters) {
                actualTypeArguments.add(resolveTypeDefinition(actualTypeParameter));
            }
            return new GenericTypeDefinition(rawType, actualTypeArguments);
        }

        private static TypeDefinition resolveTypeDefinition(Type actualTypeParameter) {
            if (actualTypeParameter instanceof ParameterizedType parameterizedType) {
                var rawType = parameterizedType.getRawType();
                var actualTypeArguments = parameterizedType.getActualTypeArguments();
                return resolveTypeDefinition((Class<?>) rawType, actualTypeArguments);
            }
            return new NormalTypeDefinition((Class<?>) actualTypeParameter);
        }
    }

    private record NormalTypeDefinition(Class<?> rawType) implements TypeDefinition {
        @Override
        public boolean isGeneric() {
            return false;
        }

        @Override
        public Class<?> getType() {
            return rawType;
        }

        @Override
        public GenericTypeDefinition getGenericType() {
            throw new UnsupportedOperationException();
        }
    }

    private record GenericTypeDefinition(
            Class<?> rawType, List<TypeDefinition> actualTypeArguments
    ) implements TypeDefinition {

        @Override
        public boolean isGeneric() {
            return true;
        }

        @Override
        public Class<?> getType() {
            return rawType;
        }

        @Override
        public GenericTypeDefinition getGenericType() {
            return this;
        }
    }

    static class Utils {
        public static Object setField(Field field, Object owner) {
            try {
                return field.get(owner);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        public static Field getFiled(Class<?> classType, String fieldName) {
            try {
                var field = classType.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
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
        private Map<String, List<List<Float>>> member2; // 集合2，复杂类型
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
