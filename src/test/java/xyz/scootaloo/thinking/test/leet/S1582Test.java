package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1582;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/04 - 10:02
 */
public class S1582Test {

    private final S1582 solution = new S1582();

    @Test
    public void test() {
        int[][] input = {
                { 1, 0, 0 },
                { 0, 0, 1 },
                { 1, 0, 0 }
        };
        System.out.println(solution.numSpecial(input));
    }

    @Test
    public void test1() {
        int[][] input = {
                { 0, 0, 0, 1 },
                { 1, 0, 0, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };
        System.out.println(solution.numSpecial(input));
    }

    @Test
    public void test2() {
        int[][] input = {
                { 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1 }
        };
        System.out.println(solution.numSpecial(input));
    }

}
