package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S886;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/16 - 20:35
 */
public class S886Test {

    private final S886 solution = new S886();

    @Test
    public void test() {
        int[][] input = {
                {1, 2},
                {1, 3},
                {2, 4}
        };
        System.out.println(solution.possibleBipartition(4, input));
    }

}
