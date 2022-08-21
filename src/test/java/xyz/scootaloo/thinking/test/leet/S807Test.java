package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S807;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 20:35
 */
public class S807Test {

    private final S807 solution = new S807();

    @Test
    public void test() {
        int[][] grid = {
                { 3, 0, 8, 4 },
                { 2, 4, 5, 7 },
                { 9, 2, 6, 3 },
                { 0, 3, 1, 0 }
        };
        assert solution.maxIncreaseKeepingSkyline(grid) == 35;
    }

}
