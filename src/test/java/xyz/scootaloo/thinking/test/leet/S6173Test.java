package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S6173;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/03 - 23:32
 */
public class S6173Test {

    private final S6173 solution = new S6173();

    @Test
    public void test() {
        int[][] input = {
                { 0, 0, 0 },
                { 1, 0, 1 },
                { 0, 1, 1 },
                { 0, 0, 1 },
        };
        System.out.println(solution.maximumRows(input, 2));
    }

    @Test
    public void test1() {
        int[][] input = {
                { 0 },
                { 1 }
        };
        System.out.println(solution.maximumRows(input, 1));
    }

}
