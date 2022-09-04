package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S646;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/03 - 10:27
 */
public class S646Test {

    private final S646 solution = new S646();

    @Test
    public void test() {
        int[][] input = {
                { 1, 2 }, { 2, 3 }, { 3, 4 }
        };
        System.out.println(solution.findLongestChain(input));
    }

}
