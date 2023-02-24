package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1326;

/**
 * @author AppleSack
 * @since 2023/02/21
 */
public class S1326Test {

    private final S1326 solution = new S1326();

    @Test
    public void test() {
        System.out.println(solution.minTaps(5, new int[] { 3, 4, 1, 1, 0, 0 })); // 1
        System.out.println(solution.minTaps(3, new int[] { 0, 0, 0, 0 }));       // -1
        System.out.println(solution.minTaps(4, new int[] { 1, 1, 0, 0, 1 }));    // 2
        System.out.println(solution.minTaps(5, new int[] { 1, 1, 0, 0, 0, 1 })); // -1
        System.out.println(solution.minTaps(2, new int[] { 1, 2, 3 }));          // 1
    }

    @Test
    public void test1() {
        System.out.println(solution.minTaps(2, new int[] { 1, 2, 3 }));
    }

    @Test
    public void test2() {
        System.out.println(solution.minTaps(5, new int[] { 1, 1, 0, 0, 0, 1 }));
    }

    @Test                 //                                          4  4  4  4  4  4  4
    public void test3() { //                                 5  5  5  5  5  5  5
        System.out.println(solution.minTaps(9, new int[] { 0, 5, 0, 3, 3, 3, 1, 4, 0, 4 }));
        System.out.println(solution.minTaps(9, new int[] { 0, 0, 2, 2, 2, 2, 2, 2, 2, 0, 0 }));
        //     4 4 4 4 4 4 4 4
        //     3 3 3 3 3 3 3
        //   3 3 3 3 3 3 3
        // 3 3 3 3 3 3 3
        // 5 5 5 5 5 5 5
        // 0 1 2 3 4 5 6 7 8 9

        //           1 1 1 1 1 1
        //         1 1 1 1 1 1
        //       1 1 1 1 1 1
        //     1 1 1 1 1
        //   1 1 1 1 1
        // 1 1 1 1 1
    }

}
