package xyz.scootaloo.thinking.test.draft;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @author AppleSack
 * @since 2023/01/23
 */
public class TestLinkedList {

    @Test
    public void benchmark() {
        long start = System.currentTimeMillis();
        Object o;
        LinkedList<Stu> ls = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            ls.addLast(new Stu(String.valueOf(i), i));
        }
        for (int i = 0; i < 100000; i++) {
            o = ls.get(i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private record Stu(String name, int age) {
    }

}
