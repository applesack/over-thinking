package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1039;

/**
 * @author AppleSack
 * @since 2023/04/02
 */
public class S1039Test {

    private final S1039 solution = new S1039();

    @Test
    public void test() {
        System.out.println(solution.minScoreTriangulation(new int[]{1, 2, 3})); // 6
        System.out.println(solution.minScoreTriangulation(new int[]{3, 7, 4, 5})); // 144
    }

}
