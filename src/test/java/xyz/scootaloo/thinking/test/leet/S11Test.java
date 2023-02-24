package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S11;

/**
 * @author AppleSack
 * @since 2023/02/19
 */
public class S11Test {

    private final S11 solution = new S11();

    @Test
    public void test() {
        System.out.println(solution.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(solution.maxArea(new int[] { 1, 1 }));
    }

}
