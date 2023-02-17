package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.SInterview0108;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/30 - 13:41
 */
public class SInterview0108Test {

    private final SInterview0108 solution = new SInterview0108();

    @Test
    public void test() {
        int[][] mat = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution.setZeroes(mat);
        System.out.println();
    }

}
