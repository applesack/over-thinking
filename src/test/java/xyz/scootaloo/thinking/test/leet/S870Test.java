package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S870;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/08 - 9:32
 */
public class S870Test {

    private final S870 solution = new S870();

    @Test
    public void test() {
        int[] input1 = { 2, 7, 11, 15 };
        int[] input2 = { 1, 10, 4, 11 };
        System.out.println(Arrays.toString(solution.advantageCount(input1, input2)));
    }

    @Test
    public void test2() {
        int[] input1 = { 12, 24, 8, 32 };
        int[] input2 = { 13, 25, 32, 11 };
        System.out.println(Arrays.toString(solution.advantageCount(input1, input2)));
    }

}
