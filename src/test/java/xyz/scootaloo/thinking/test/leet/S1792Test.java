package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1792;

/**
 * @author AppleSack
 * @since 2023/02/19
 */
public class S1792Test {

    private final S1792 solution = new S1792();

    @Test
    public void test() {
        System.out.println(solution.maxAverageRatio(new int[][] {
                { 1, 2 }, { 3, 5 }, { 2, 2 }
        }, 2));
    }

}
