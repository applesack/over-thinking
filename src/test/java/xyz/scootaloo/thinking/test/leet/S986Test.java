package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S986;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/02/19
 */
public class S986Test {

    private final S986 solution = new S986();

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(solution.intervalIntersection(new int[][] {
                { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 }
        }, new int[][] {
                { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 }
        })));
    }

    @Test
    public void test1() {
        System.out.println(Arrays.deepToString(solution.intervalIntersection(new int[][] {
                { 1, 3 }, { 5, 9 }
        }, new int[][] {
        })));
    }

    @Test
    public void test2() {
        System.out.println(Arrays.deepToString(solution.intervalIntersection(new int[][] {
        }, new int[][] {
                { 4, 8 }, { 10, 12 }
        })));
    }

    @Test
    public void test3() {
        System.out.println(Arrays.deepToString(solution.intervalIntersection(new int[][] {
                { 1, 7 }
        }, new int[][] {
                { 3, 10 }
        })));
    }

}
