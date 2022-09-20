package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1619;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/14 - 8:27
 */
public class S1619Test {

    private final S1619 solution = new S1619();

    @Test
    public void test() {
        int[] input = { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };
        System.out.println(solution.trimMean(input));
    }

}
