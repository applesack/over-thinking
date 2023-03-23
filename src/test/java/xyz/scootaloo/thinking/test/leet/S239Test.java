package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S239;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/03/23
 */
public class S239Test {

    private final S239 solution = new S239();

    @Test
    public void test() {
        System.out.println(Arrays.toString(
                solution.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));

        System.out.println(Arrays.toString(
                solution.maxSlidingWindow(new int[] { 1 }, 1)));
    }

}
