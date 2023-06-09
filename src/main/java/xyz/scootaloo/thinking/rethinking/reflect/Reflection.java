package xyz.scootaloo.thinking.rethinking.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/06/09
 */
public class Reflection {

    public static TypeDefinition deconstruction(Class<?> classType) {
        return resolveTypeDefinition(classType, null);
    }

    static TypeDefinition resolveTypeDefinition(Class<?> rawType, Type[] actualTypeParameters) {
        checkTypeParameterList(rawType, actualTypeParameters);
        if (actualTypeParameters == null) {
            return new NormalTypeDefinition(rawType, resolveRawTypeMark(rawType));
        }
        var actualTypeArguments = new ArrayList<TypeDefinition>(actualTypeParameters.length);
        for (var actualTypeParameter : actualTypeParameters) {
            actualTypeArguments.add(resolveTypeDefinition(actualTypeParameter));
        }
        return new GenericTypeDefinition(rawType, actualTypeArguments, resolveRawTypeMark(rawType));
    }

    private static void checkTypeParameterList(Class<?> rawType, Type[] actualTypeParameters) {
        var atpSize = actualTypeParameters == null ? 0 : actualTypeParameters.length;
        assert rawType.getTypeParameters().length == atpSize;
    }

    private static TypeDefinition resolveTypeDefinition(Type actualTypeParameter) {
        if (actualTypeParameter instanceof ParameterizedType parameterizedType) {
            var rawType = parameterizedType.getRawType();
            var actualTypeArguments = parameterizedType.getActualTypeArguments();
            return resolveTypeDefinition((Class<?>) rawType, actualTypeArguments);
        }
        var classRawType = (Class<?>) actualTypeParameter;
        return new NormalTypeDefinition(classRawType, resolveRawTypeMark(classRawType));
    }

    private static int resolveRawTypeMark(Class<?> rawType) {
        return TypeMark.resolveTypeMark(rawType);
    }

    private record NormalTypeDefinition(Class<?> rawType, int mark) implements TypeDefinition {
        @Override
        public boolean isGeneric() {
            return false;
        }

        @Override
        public Class<?> getRawType() {
            return rawType;
        }

        @Override
        public GenericTypeDefinition getGenericType() {
            throw new UnsupportedOperationException();
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
}
