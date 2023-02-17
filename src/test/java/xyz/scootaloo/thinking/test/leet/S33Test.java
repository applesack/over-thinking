package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S33;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S33Test {

    private final S33 solution = new S33();

    @Test
    public void test() {
        System.out.println(solution.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        System.out.println(solution.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
        System.out.println(solution.search(new int[] { 1 }, 0));
        System.out.println(solution.search(new int[] { 3, 1 }, 1));
        System.out.println(solution.search(new int[] { 3, 1 }, 3));
    }

    @Test
    public void test1() {
        System.out.println(solution.search(new int[] { 3, 1 }, 1));
    }

}
