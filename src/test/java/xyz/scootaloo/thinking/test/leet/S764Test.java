package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S764;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/09 - 12:47
 */
public class S764Test {

    private final S764 solution = new S764();

    @Test
    public void test() {
        System.out.println(solution.orderOfLargestPlusSign(5, new int[][] {
                { 4, 2 }
        }));
    }

    @Test
    public void test2() {
        System.out.println(solution.orderOfLargestPlusSign(5, new int[][] {
                { 0, 0 }
        }));
    }

    @Test
    public void test3() {
        System.out.println(solution.orderOfLargestPlusSign(5, new int[][] {
                { 0, 2 },
                { 0, 3 },
                { 2, 2 },
                { 2, 4 },
                { 4, 0 },
                { 4, 1 },
                { 4, 2 },
                { 4, 4 }
        }));
    }

}
