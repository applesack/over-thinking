package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S41;

/**
 * @author AppleSack
 * @since 2023/03/23
 */
public class S41Test {

    private final S41 solution = new S41();

    @Test
    public void test() {
        System.out.println(solution.firstMissingPositive(new int[] { 1, 2, 0 })); // 3
        System.out.println(solution.firstMissingPositive(new int[] { 0, 1, 2 })); // 3
        System.out.println(solution.firstMissingPositive(new int[] { 1, 4, 5 })); // 2
        System.out.println(solution.firstMissingPositive(new int[] { 3, 4, -1, 1 })); // 2
        System.out.println(solution.firstMissingPositive(new int[] { 7, 8, 9, 11, 12 })); // 1
        System.out.println(solution.firstMissingPositive(new int[] { 0, 2, 2, 1, 1 })); // 3
    }

    @Test
    public void test1() {
        System.out.println(solution.firstMissingPositive(new int[] { 0, 1, 2 })); // 3
    }
}
