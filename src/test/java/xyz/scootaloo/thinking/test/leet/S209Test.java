package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S209;

/**
 * @author AppleSack
 * @since 2023/02/20
 */
public class S209Test {

    private final S209 solution = new S209();

    @Test
    public void test() {
        System.out.println(solution.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 3, 4 }));
        System.out.println(solution.minSubArrayLen(7, new int[] { 1, 4, 4 }));
        System.out.println(solution.minSubArrayLen(4, new int[] { 1, 4, 4 }));
    }

    @Test
    public void test1() {
        System.out.println(solution.minSubArrayLen(7, new int[] { 1, 4, 4 }));
        System.out.println(solution.minSubArrayLen(8, new int[] { 1, 4, 4 }));
        System.out.println(solution.minSubArrayLen(8, new int[] { 4, 4 }));
    }

}
