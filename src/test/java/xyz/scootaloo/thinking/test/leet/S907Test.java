package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S907;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/06 - 12:27
 */
public class S907Test {

    private final S907 solution = new S907();

    @Test
    public void test() {
        int[] input = { 3, 1, 2, 4 };
        System.out.println(solution.sumSubarrayMins(input));
    }

    @Test
    public void test1() {
        int[] input = { 11, 81, 94, 43, 3 };
        System.out.println(solution.sumSubarrayMins(input));
    }

    @Test
    public void test2() {
        int[] input = { 71, 55, 82, 55 };
        System.out.println(solution.sumSubarrayMins(input));
    }

    @Test
    public void test3() {
        int[] input = ToolBox.readIntArray("input/907_1.txt");
        System.out.println(solution.sumSubarrayMins(input));
    }

}
