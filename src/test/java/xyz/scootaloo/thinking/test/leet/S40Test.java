package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S40;

/**
 * @author AppleSack
 * @since 2023/02/25
 */
public class S40Test {

    private final S40 solution = new S40();

    @Test
    public void test() {
        System.out.println(solution.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 7));
        System.out.println(solution.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
        System.out.println(solution.combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));
    }

}
