package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1640;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/22 - 9:59
 */
public class S1640Test {

    private final S1640 solution = new S1640();

    @Test
    public void test() {
        int[] arr = { 15, 88 };
        int[][] pieces = { { 88 }, { 15 } };
        System.out.println(solution.canFormArray(arr, pieces));
    }

    @Test
    public void test1() {
        int[] arr = { 49, 18, 16 };
        int[][] pieces = { { 16, 18, 49 } };
        System.out.println(solution.canFormArray(arr, pieces));
    }

    @Test
    public void test2() {
        int[] arr = { 91, 4, 64, 78 };
        int[][] pieces = { { 78 }, { 4, 64 }, { 91 } };
        System.out.println(solution.canFormArray(arr, pieces));
    }

}
