package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S2367;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 17:00
 */
public class S2367Test {

    private final S2367 solution = new S2367();

    @Test
    public void test() {
        int[] nums = { 0, 1, 4, 6, 7, 10 };
        int diff = 3;
        assert solution.arithmeticTriplets(nums, diff) == 2;
    }

}
