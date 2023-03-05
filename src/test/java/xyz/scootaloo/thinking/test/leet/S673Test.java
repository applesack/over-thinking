package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S673;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S673Test {

    private final S673 solution = new S673();

    @Test
    public void test() {
        System.out.println(solution.findNumberOfLIS(new int[] { 1, 3, 5, 4, 7 })); // 2
        System.out.println(solution.findNumberOfLIS(new int[] { 2, 2, 2, 2, 2 })); // 5
    }

    @Test
    public void test1() {
        // 1 2 3 4 7
        // 1 2 3 5 7
        // 1 2 3 5 7
        System.out.println(solution.findNumberOfLIS(new int[] { 1, 2, 4, 3, 5, 4, 7, 2 })); // 3
    }

}
