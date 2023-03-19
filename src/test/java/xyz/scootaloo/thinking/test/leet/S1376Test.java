package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1376;

/**
 * @author AppleSack
 * @since 2023/03/18
 */
public class S1376Test {

    private final S1376 solution = new S1376();

    @Test
    public void test() {
        System.out.println(solution.numOfMinutes(1, 0,
                new int[] { -1 },
                new int[] { 0 })
        ); // 0

        System.out.println(solution.numOfMinutes(6, 2,
                new int[] { 2, 2, -1, 2, 2, 2 },
                new int[] { 0, 0, 1, 0, 0, 0 })
        ); // 1

        System.out.println(solution.numOfMinutes(15, 0,
                new int[] { -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 },
                new int[] { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 })
        ); // 3
    }

}
