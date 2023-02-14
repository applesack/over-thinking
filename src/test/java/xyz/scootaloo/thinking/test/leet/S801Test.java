package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S801;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/10 - 21:58
 */
public class S801Test {

    private final S801 solution = new S801();

    @Test
    public void test() {
        int[] num1 = { 1, 3, 5, 4 };
        int[] num2 = { 1, 2, 3, 7 };
        System.out.println(solution.minSwap(num1, num2));
    }

    @Test
    public void test1() {
        int[] num1 = { 0, 3, 5, 8, 9 };
        int[] num2 = { 2, 1, 4, 6, 9 };
        System.out.println(solution.minSwap(num1, num2));
    }

}
