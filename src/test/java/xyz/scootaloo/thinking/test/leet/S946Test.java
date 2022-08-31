package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S946;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/31 - 9:55
 */
public class S946Test {

    private final S946 solution = new S946();

    @Test
    public void test() {
        int[] input1 = { 1, 2, 3, 4, 5 };
        int[] input2 = { 5, 4, 3, 2, 1 };
        System.out.println(solution.validateStackSequences(input1, input2));
    }

    @Test
    public void test1() {
        int[] input1 = { 1, 2, 3, 4, 5 };
        int[] input2 = { 4, 3, 5, 1, 2 };
        System.out.println(solution.validateStackSequences(input1, input2));
    }

}
