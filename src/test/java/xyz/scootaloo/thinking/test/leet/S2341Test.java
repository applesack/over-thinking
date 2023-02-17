package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S2341;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/02/16
 */
public class S2341Test {

    private final S2341 solution = new S2341();

    @Test
    public void test() {
        System.out.println(Arrays.toString(solution.numberOfPairs(new int[] { 1, 3, 2, 1, 3, 2, 2 })));
    }

    @Test
    public void test1() {
        System.out.println(Arrays.toString(solution.numberOfPairs(new int[] { 1, 1 })));
    }

    @Test
    public void test2() {
        System.out.println(Arrays.toString(solution.numberOfPairs(new int[] { 0 })));
    }

}
