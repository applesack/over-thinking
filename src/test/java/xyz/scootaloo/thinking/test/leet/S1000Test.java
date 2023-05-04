package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1000;

/**
 * @author AppleSack
 * @since 2023/04/04
 */
public class S1000Test {

    private final S1000 solution = new S1000();

    @Test
    public void test() {
        System.out.println(solution.mergeStones(new int[] { 3, 2, 4, 1 }, 2)); // 20
        System.out.println(solution.mergeStones(new int[] { 3, 2, 4, 1 }, 3)); // -1
        System.out.println(solution.mergeStones(new int[] { 3, 5, 1, 2, 6 }, 3)); // 26
    }

    @Test
    public void test1() {
        System.out.println(solution.mergeStones(new int[] { 3, 2, 4, 1 }, 2)); // 20
    }

}
