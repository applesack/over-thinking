package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S768;

/**
 * @author flutterdash@qq.com
 * @since 2022/8/13 上午9:21
 */
public class S768Test {

    private final S768 solution = new S768();

    @Test
    public void test() {
        int[] input = {5, 4, 3, 2, 1};
        assert solution.maxChunksToSorted(input) == 1;
    }

    @Test
    public void test2() {
        int[] input = {2, 1, 3, 4, 4};
        assert solution.maxChunksToSorted(input) == 4;
    }

}
