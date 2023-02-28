package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S213;

/**
 * @author AppleSack
 * @since 2023/02/28
 */
public class S213Test {

    private final S213 solution = new S213();

    @Test
    public void test() {
        System.out.println(solution.rob(new int[] { 2, 3, 2 }));
        System.out.println(solution.rob(new int[] { 1, 2, 3, 1 }));
        System.out.println(solution.rob(new int[] { 1, 2, 3 }));
        System.out.println(solution.rob(new int[] { 1, 3, 1, 3, 100 }));
    }

}
