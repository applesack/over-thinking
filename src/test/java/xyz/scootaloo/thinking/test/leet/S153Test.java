package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S153;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S153Test {

    private final S153 solution = new S153();

    @Test
    public void test() {
        System.out.println(solution.findMin(new int[] { 3, 4, 5, 1, 2 }));
        System.out.println(solution.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
        System.out.println(solution.findMin(new int[] { 11, 13, 15, 17 }));
    }

    @Test
    public void test1() {
        System.out.println(solution.findMin(new int[] { 1, 2 }));
        System.out.println(solution.findMin(new int[] { 2, 1 }));
    }

}
