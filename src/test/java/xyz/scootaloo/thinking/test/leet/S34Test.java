package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S34;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S34Test {

    private final S34 solution = new S34();

    @Test
    public void test() {
        System.out.println(Arrays.toString(solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
        System.out.println(Arrays.toString(solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 10)));
        System.out.println(Arrays.toString(solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 5)));
        System.out.println(Arrays.toString(solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 11)));
        System.out.println(Arrays.toString(solution.searchRange(new int[] { 0 }, 11)));
    }

}
