package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S300;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S300Test {

    private final S300 solution = new S300();

    @Test
    public void test() {
        System.out.println(solution.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })); // 4
        System.out.println(solution.lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));    // 4
        System.out.println(solution.lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 })); // 1
    }

    @Test
    public void test1() {
        System.out.println(solution.lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));    // 4
    }

}
