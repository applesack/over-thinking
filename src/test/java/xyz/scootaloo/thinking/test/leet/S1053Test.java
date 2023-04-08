package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1053;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/04/03
 */
public class S1053Test {

    private final S1053 solution = new S1053();

    @Test
    public void test() {
        display(solution.prevPermOpt1(new int[] { 1, 2, 3 })); // 1, 2, 3
        display(solution.prevPermOpt1(new int[] { 1, 3, 2 })); // 1, 2, 3
        display(solution.prevPermOpt1(new int[] { 2, 1, 3 })); // 1, 3, 2
        display(solution.prevPermOpt1(new int[] { 2, 3, 1 })); // 2, 1, 3
        display(solution.prevPermOpt1(new int[] { 3, 1, 2 })); // 2, 3, 1
        display(solution.prevPermOpt1(new int[] { 3, 2, 1 })); // 3, 1, 2
        display(solution.prevPermOpt1(new int[] { 1, 9, 4, 6, 7 })); // 1, 7, 4, 6, 9
    }

    @Test
    public void test1() {
        display(solution.prevPermOpt1(new int[] { 2, 1, 3 })); // 1, 3, 2
    }

    @Test
    public void test2() {
        display(solution.prevPermOpt1(new int[] { 3, 2, 1 })); //3, 1, 2
        display(solution.prevPermOpt1(new int[] { 1, 1, 5 })); // 1, 1, 5
        display(solution.prevPermOpt1(new int[] { 1, 9, 4, 6, 7 })); // 1, 7, 4, 6, 9
        display(solution.prevPermOpt1(new int[] { 3, 1, 1, 3 })); // 1, 3, 1, 3
        //                                                           1  1  3  3
    }

    @Test
    public void test3() {
        display(solution.prevPermOpt1(new int[] { 3, 1, 1, 3 }));
    }

    private void display(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

}
