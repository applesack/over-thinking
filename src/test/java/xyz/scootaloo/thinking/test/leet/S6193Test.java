package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S6193;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/02 - 10:43
 */
public class S6193Test {

    private final S6193 solution = new S6193();

    @Test
    public void test() {
        int[][] input = {
                { 6, 2, 1, 3 },
                { 4, 2, 1, 5 },
                { 9, 2, 8, 7 },
                { 4, 1, 2, 9 }
        };
        System.out.println(solution.maxSum(input));
    }

    @Test
    public void test2() {
        int[][] input = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(solution.maxSum(input));
    }

}
