package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/02/16
 */
public class S1Test {

    private final S1 solution = new S1();

    @Test
    public void test() {
        System.out.println(Arrays.toString(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9)));
    }

    @Test
    public void test1() {
        System.out.println(Arrays.toString(solution.twoSum(new int[] { 3, 2, 4 }, 6)));
    }

}
