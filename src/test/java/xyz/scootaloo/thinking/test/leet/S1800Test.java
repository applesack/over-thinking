package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1800;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/07 - 8:36
 */
public class S1800Test {

    private final S1800 solution = new S1800();

    @Test
    public void test() {
        System.out.println(solution.maxAscendingSum(new int[] { 10, 20, 30, 5, 10, 50 })); // 65
        System.out.println(solution.maxAscendingSum(new int[] { 10, 20, 30, 40, 50 })); // 150
        System.out.println(solution.maxAscendingSum(new int[] { 12, 17, 15, 13, 10, 11, 12 })); // 33
        System.out.println(solution.maxAscendingSum(new int[] { 100, 10, 1 })); // 100
    }

}
