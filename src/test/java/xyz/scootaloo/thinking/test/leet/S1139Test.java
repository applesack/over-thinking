package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1139;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S1139Test {

    private final S1139 solution = new S1139();

    @Test
    public void test() {
        System.out.println(solution.largest1BorderedSquare(new int[][] {
                { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }
        }));
        System.out.println(solution.largest1BorderedSquare(new int[][] {
                { 1, 1 }, { 0, 0 }
        }));
        System.out.println(solution.largest1BorderedSquare(new int[][] {
                { 1 }
        }));
    }

    @Test
    public void test1() {
        System.out.println(solution.largest1BorderedSquare(new int[][] {
                { 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0 }
        }));
    }

    @Test
    public void test2() {
        System.out.println(solution.largest1BorderedSquare(new int[][] {
                { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }
        }));
    }

}
