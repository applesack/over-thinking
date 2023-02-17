package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S805;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/14 - 18:36
 */
public class S805Test {

    private final S805 solution = new S805();

    @Test
    public void test() {
        System.out.println(solution.splitArraySameAverage(new int[] {
                1, 2, 3, 4, 5, 6, 7, 8
        }));
        System.out.println(solution.splitArraySameAverage(new int[] {
                1, 3
        }));
    }

}
