package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S769;

/**
 * @author flutterdash@qq.com
 * @since 2022/8/13 上午8:55
 */
public class S769Test {

    private final S769 solution = new S769();

    @Test
    public void test() {
        int[] input = {4, 3, 2, 1, 0};
        assert solution.maxChunksToSorted(input) == 1;
    }

    @Test
    public void test1() {
        int[] input = {1, 0, 2, 3, 4};
        assert solution.maxChunksToSorted(input) == 4;
    }

    @Test
    public void test3() {
        int[] input = {4, 3, 2, 1, 0};
        assert solution.maxChunksToSorted(input) == 1;
    }

}
