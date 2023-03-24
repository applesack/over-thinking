package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S454;

/**
 * @author AppleSack
 * @since 2023/03/23
 */
public class S454Test {

    private final S454 solution = new S454();

    @Test
    public void test() {
        System.out.println(solution.fourSumCount(
                new int[] { 1, 2 },
                new int[] { -2, -1 },
                new int[] { -1, 2 },
                new int[] { 0, 2 }
        )); // 2

        System.out.println(solution.fourSumCount(
                new int[] { 0 },
                new int[] { 0 },
                new int[] { 0 },
                new int[] { 0 }
        )); // 1

        System.out.println(solution.fourSumCount(
                new int[] { -1, -1 },
                new int[] { -1, 1 },
                new int[] { -1, 1 },
                new int[] { 1, -1 }
        )); // 6
    }

}
