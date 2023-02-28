package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1091;

/**
 * @author AppleSack
 * @since 2023/02/23
 */
public class S1091Test {

    private final S1091 solution = new S1091();

    @Test
    public void test() {
        System.out.println(solution.shortestPathBinaryMatrix(new int[][] {
                { 0, 1 },
                { 1, 0 }
        }));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][] {
                { 0, 0, 0 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        }));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][] {
                { 1, 0, 0 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        }));
    }

}
