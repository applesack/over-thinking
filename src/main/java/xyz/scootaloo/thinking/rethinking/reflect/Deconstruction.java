package xyz.scootaloo.thinking.rethinking.reflect;

import xyz.scootaloo.thinking.rethinking.reflect.TypeDefinition.Property;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author AppleSack
 * @since 2023/06/09
 */
public class Deconstruction {

    public static TypeDefinition deconstruct(Class<?> classType) {
        return resolveTypeDefinition(classType, null);
    }

    private static TypeDefinition resolveTypeDefinition(Class<?> rawType, Type[] actualTypeParameters) {
        if (ArrayUtils.isArray(rawType)) {
            return resolveArrayTypeDefinition(rawType, actualTypeParameters);
        }
        checkTypeParameterList(rawType, actualTypeParameters);
        if (actualTypeParameters == null) {
            return normalTypeDefinition(rawType);
        }
        var actualTypeArguments = new ArrayList<TypeDefinition>(actualTypeParameters.length);
        for (var actualTypeParameter : actualTypeParameters) {
            actualTypeArguments.add(resolveTypeDefinition(actualTypeParameter));
        }
        return new GenericTypeDefinition(rawType, actualTypeArguments, resolveRawTypeMark(rawType));
    }

    private static TypeDefinition resolveArrayTypeDefinition(Class<?> arrayType, Type[] actualTypeParameters) {
        // 如果被解析类型为 List<String>[], 那么泛型参数应该是String, 且rawType是List
        checkTypeParameterList(arrayType, actualTypeParameters);
        return null;
    }

    private static TypeDefinition resolveTypeDefinition(Type actualTypeParameter) {
        if (actualTypeParameter instanceof ParameterizedType parameterizedType) {
            var rawType = parameterizedType.getRawType();
            var actualTypeArguments = parameterizedType.getActualTypeArguments();
            return resolveTypeDefinition((Class<?>) rawType, actualTypeArguments);
        }
        return normalTypeDefinition((Class<?>) actualTypeParameter);
    }

    private static Type[] getFieldGenericArrayType(Field field) {
        // List<String>[]
        var genericType = field.getGenericType();
        if (genericType instanceof GenericArrayType genericArrayType) {
            var genericComponentType = genericArrayType.getGenericComponentType();
            if (genericComponentType instanceof ParameterizedType parameterizedType) {
                return parameterizedType.getActualTypeArguments();
            }
        }
        return null;
    }

    private static NormalTypeDefinition normalTypeDefinition(Class<?> rawType) {
        var constructor = findNonArgConstructor(rawType);
        var typeMark = resolveRawTypeMark(rawType);
        var properties = findProperties(rawType);
        return new NormalTypeDefinition(rawType, constructor::newInstance, properties, typeMark);
    }

    private static Constructor<?> findNonArgConstructor(Class<?> rawType) {
        for (var constructor : rawType.getConstructors()) {
            if (constructor.getParameterCount() == 0) {
                constructor.setAccessible(true);
                return constructor;
            }
        }
        throw new IllegalStateException("non arg constructor not found");
    }

    private static List<Property> findProperties(Class<?> classType) {
        var declaredFields = classType.getDeclaredFields();
        if (declaredFields.length == 0) {
            return Property.EMPTY_PROPERTIES;
        }
        var properties = new ArrayList<Property>(declaredFields.length);
        for (var field : declaredFields) {
            field.setAccessible(true);
            var fName = field.getName();
            var fType = field.getType();
            if (ArrayUtils.isArray(fType)) {
                var fieldGenericArrayType = getFieldGenericArrayType(field);
                if (fieldGenericArrayType == null) {
                    // 非泛型数组f
                } else {
                    // 泛型数组
                }
            } else {

            }
        }
        return null;
    }

    private static void checkTypeParameterList(Class<?> rawType, Type[] actualTypeParameters) {
        var atpSize = actualTypeParameters == null ? 0 : actualTypeParameters.length;
        assert rawType.getTypeParameters().length == atpSize;
    }

    private static int resolveRawTypeMark(Class<?> rawType) {
        return TypeMark.resolveTypeMark(rawType);
    }

    private Deconstruction() {
    }

    public record NormalTypeDefinition(
            Class<?> rawType, TypeDefinition.Factory constructor, List<Property> properties, int mark
    ) implements TypeDefinition {
        @Override
        public boolean isGeneric() {
            return false;
        }

        @Override
        public boolean isArray() {
            return false;
        }

        @Override
        public boolean hasProperties() {
            return properties != Property.EMPTY_PROPERTIES;
        }

        @Override
        public Iterator<Property> getProperties() {
            return properties.iterator();
        }

        @Override
        public Class<?> getRawType() {
            return rawType;
        }

        @Override
        public GenericTypeDefinition getGenericType() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object newInstance() {
            return TypeDefinition.safeNewInstance(constructor);
        }
    }

    public record FieldProperty(String name, Field field, TypeDefinition definition) implements Property {
        @Override
        public void set(Object owner, Object value) {
            TypeDefinition.unsafeNewInstance(() -> {
                field.set(owner, value);
                return null;
            });
        }

        @Override
        public Object get(Object owner) {
            return TypeDefinition.unsafeNewInstance(() -> field.get(owner));
        }
    }

    public enum TypeMark {
        LIST, QUEUE, SET, MAP;

        /* 对象类型 */
        public static final int object = 0;

        /* [1,10] 基本类型 */
        public static final int t_bool   = 1;
        public static final int t_byte   = 2;
        public static final int t_short  = 3;
        public static final int t_int    = 4;
        public static final int t_float  = 5;
        public static final int t_double = 6;
        public static final int t_long   = 7;
        public static final int t_string = 8;

        /* [11,20] 包装类型 */
        public static final int w_bool   = 11;
        public static final int w_byte   = 12;
        public static final int w_short  = 13;
        public static final int w_int    = 14;
        public static final int w_float  = 15;
        public static final int w_double = 16;
        public static final int w_long   = 17;

        /* [20, inf] 集合类型 */
        public static final int ls             = 20;
        public static final int ls_array_list  = 21;
        public static final int ls_linked_list = 22;

        public static final int que       = 30;
        public static final int que_deque = 31;
        public static final int que_pq    = 32;

        public static final int set      = 40;
        public static final int set_hash = 41;
        public static final int set_tree = 42;

        public static final int map      = 50;
        public static final int map_hash = 51;
        public static final int map_tree = 52;

        private static final Map<String, Integer> markMap = new HashMap<>();

        static {
            put("boolean", t_bool);
            put("byte", t_byte);
            put("short", t_short);
            put("int", t_int);
            put("float", t_float);
            put("double", t_double);
            put("long", t_long);
            put("java.lang.String", t_string);
            put("java.lang.Boolean", w_bool);
            put("java.lang.Byte", w_byte);
            put("java.lang.Short", w_short);
            put("java.lang.Integer", w_int);
            put("java.lang.Float", w_float);
            put("java.lang.Double", w_double);
            put("java.lang.Long", w_long);
            put("java.util.List", ls);
            put("java.util.ArrayList", ls_array_list);
            put("java.util.LinkedList", ls_linked_list);
            put("java.util.Queue", que);
            put("java.util.Deque", que_deque);
            put("java.util.PriorityQueue", que_pq);
            put("java.util.Set", set);
            put("java.util.HashSet", set_hash);
            put("java.util.TreeSet", set_tree);
            put("java.util.Map", map);
            put("java.util.HashMap", map_hash);
            put("java.util.TreeMap", map_tree);
        }

        public static int resolveTypeMark(Class<?> classType) {
            var typeName = classType.getTypeName();
            if (markMap.containsKey(typeName)) {
                return markMap.get(typeName);
            }
            return object;
        }

        public static boolean isBasicType(int mark) {
            return mark > 0 && mark < 20;
        }

        public static boolean isWrapperType(int mark) {
            return mark > 10 && mark < 20;
        }

        public static TypeMark getType(int mark) {
            if (mark < 20) {
                throw new IllegalArgumentException(mark + " is not a collection mark");
            }
            if (mark < 30) {
                return LIST;
            }
            if (mark < 40) {
                return QUEUE;
            }
            if (mark < 50) {
                return SET;
            }
            if (mark < 60) {
                return MAP;
            }
            throw new IllegalArgumentException(mark + " is not a collection mark");
        }

        private static void put(String typeName, int mark) {
            markMap.put(typeName, mark);
        }
    }

    public static class ArrayUtils {
        private ArrayUtils() {
        }

        public static boolean isArray(Class<?> classType) {
            return classType.isArray();
        }

        public static Object newArray(Class<?> componentType, int length) {
            return Array.newInstance(componentType, length);
        }
    }
}
