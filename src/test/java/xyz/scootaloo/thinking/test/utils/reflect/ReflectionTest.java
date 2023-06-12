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

    @Test
    public void testFieldSet() {
        /*
            basicType     : getGenericType() => Class
            genericType   : getGenericType() => ParameterizedType
            genericArrType: isArray() => true, getGenericType() => ParameterizedArrayType
         */
        var type0 = new Type0();
        var member0 = Utils.getFiled(type0.getClass(), "member0");
        Utils.setField(member0, type0, getInteger(17));
        System.out.println(type0); // int -> class
        var member6 = Utils.getFiled(type0.getClass(), "member6");
        System.out.println(member6); // set<str>[]
        var member7 = Utils.getFiled(type0.getClass(), "member7");
        System.out.println(member7); // list<str>
        var member8 = Utils.getFiled(type0.getClass(), "member8");
        System.out.println(member8);
        var member9 = Utils.getFiled(type0.getClass(), "member9");
        System.out.println(member9);
//        Utils.setField(member0, type0, null);
//        System.out.println(type0);
    }

    @Test
    public void testGenerateArray() {
        var arr = Array.newInstance(String.class, 10);
        System.out.println(arr);
    }

    @Test
    public void rawArrayType() {
        var intArray = new int[] { 1, 2, 3 };
        var doubleArray = new double[] { 0.1, 4.5, 0.0 };
        var strArray = new String[] { "az", "fd" };
        var objArray = new Object[] { "", 5 };
        System.out.println(intArray.getClass().getTypeName());
        System.out.println(doubleArray.getClass().getTypeName());
        System.out.println(strArray.getClass().getTypeName());
        System.out.println(objArray.getClass().getTypeName());
    }

    @Test
    public void genericArrayType() {
        var field = Utils.getFiled(Type0.class, "member6");
        System.out.println(field);
    }

    @Test
    public void collectionTypeCodeGen() {
        List<Class<?>> types = new ArrayList<>(20);
        types.add(boolean.class);
        types.add(byte.class);
        types.add(short.class);
        types.add(int.class);
        types.add(float.class);
        types.add(double.class);
        types.add(long.class);
        types.add(String.class);

        types.add(Boolean.class);
        types.add(Byte.class);
        types.add(Short.class);
        types.add(Integer.class);
        types.add(Float.class);
        types.add(Double.class);
        types.add(Long.class);

        types.add(List.class);
        types.add(ArrayList.class);
        types.add(LinkedList.class);

        types.add(Queue.class);
        types.add(Deque.class);
        types.add(PriorityQueue.class);

        types.add(Set.class);
        types.add(HashSet.class);
        types.add(TreeSet.class);

        types.add(Map.class);
        types.add(HashMap.class);
        types.add(TreeMap.class);

        for (var type : types) {
            var typeName = type.getTypeName();
            var prefix = "w_";
            if (typeName.contains("Set")) {
                prefix = "set";
            } else if (typeName.contains("Map")) {
                prefix = "map";
            } else if (typeName.contains("List")) {
                prefix = "ls";
            } else if (typeName.contains("ue")) {
                prefix = "que";
            } else if (typeName.toLowerCase().equals(typeName)) {
                prefix = "t_";
            }
            System.out.println("put(\"" + type.getTypeName() + "\", " + prefix + ");");
        }
    }

    private static Integer getInteger(int i) {
        return i;
    }

    static class Utils {
        public static void setField(Field field, Object owner, Object value) {
            try {
                field.set(owner, value);
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
        private int           member0; // 基础类型
        private Integer       member1; // 基本类型，包装类
        private String        member2; // 基本类型，应用类型
        private Pojo0         member3; // 引用类型1
        private Pojo1         member4; // 引用类型2
        private Pojo2         member5; // 引用类型3，复杂类型组合
        private Set<String>[] member6; // 数组类型，泛型
        private List<String>  member7; // 泛型
        private int[]         member8; // 基本类型数组
        private String[]      member9;

        @Override
        public String toString() {
            return "Type0{" +
                    "member0=" + member0 +
                    ", member1=" + member1 +
                    ", member2='" + member2 + '\'' +
                    ", member3=" + member3 +
                    ", member4=" + member4 +
                    ", member5=" + member5 +
                    '}';
        }
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
