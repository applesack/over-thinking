package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S149;

/**
 * @author AppleSack
 * @since 2023/03/08
 */
public class S149Test {

    private final S149 solution = new S149();

    @Test
    public void test() {
        System.out.println(solution.maxPoints(new int[][] {
                { 1, 1 },
                { 2, 2 },
                { 3, 3 }
        }));
        System.out.println(solution.maxPoints(new int[][] {
                { 1, 1 },
                { 3, 2 },
                { 5, 3 },
                { 4, 1 },
                { 2, 3 },
                { 1, 4 },
        }));
    }

}
