package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.LCP03;

/**
 * @author AppleSack
 * @since 2023/02/15
 */
public class LCP03Test {

    private final LCP03 solution = new LCP03();

    @Test
    public void test() {
        boolean ans = solution.robot("URR", new int[][] {
        }, 3, 2);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        boolean ans = solution.robot("URR", new int[][] {
                {2, 2}
        }, 3, 2);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        boolean ans = solution.robot("URR", new int[][] {
                {4, 2}
        }, 3, 2);
        System.out.println(ans);
    }

    @Test
    public void test4() {
        boolean ans = solution.robot("URRURRR", new int[][] {
                {7, 7}, {0, 5}, {2, 7}, {8, 6}, {8, 7}, {6, 5}, {4, 4}, {0, 3}, {3, 6}
        }, 4915, 1966);
        System.out.println(ans);
    }

}
