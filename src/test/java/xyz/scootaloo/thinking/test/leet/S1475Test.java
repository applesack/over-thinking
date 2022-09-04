package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1475;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/01 - 11:25
 */
public class S1475Test {

    private final S1475 solution = new S1475();

    @Test
    public void test() {
        int[] input = { 8, 4, 6, 2, 3 };
        System.out.println(Arrays.toString(solution.finalPrices(input)));
    }

    @Test
    public void test1() {
        int[] input = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(solution.finalPrices(input)));
    }

    @Test
    public void test2() {
        int[] input = { 10, 1, 1, 6 };
        System.out.println(Arrays.toString(solution.finalPrices(input)));
    }

    @Test
    public void test3() {
        int[] input = { 10, 2, 5, 2, 8 };
        //               8  0  3  2  8
        System.out.println(Arrays.toString(solution.finalPrices(input)));
    }

}
