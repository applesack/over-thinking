package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S15;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
public class S15Test {

    private final S15 solution = new S15();

    @Test
    public void test() {
        System.out.println(solution.threeSum(new int[] {}));
        System.out.println(solution.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(solution.threeSum(new int[] { 0, 0, 0, 0 }));
    }

}
