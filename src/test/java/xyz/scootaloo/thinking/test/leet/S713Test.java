package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S713;

/**
 * @author AppleSack
 * @since 2023/02/20
 */
public class S713Test {

    private final S713 solution = new S713();

    @Test
    public void test() {
        System.out.println(solution.numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
        System.out.println(solution.numSubarrayProductLessThanK(new int[] { 1, 2, 3 }, 0));
    }

}
