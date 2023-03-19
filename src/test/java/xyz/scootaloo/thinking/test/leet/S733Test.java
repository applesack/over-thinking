package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S733;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/03/09
 */
public class S733Test {

    private final S733 solution = new S733();

    @Test
    public void test() {
        System.out.println(
                Arrays.deepToString(
                        solution.floodFill(new int[][] {
                                {1, 1, 1},
                                {1, 1, 0},
                                {1, 0, 1}
                        }, 1, 1, 2)));
        System.out.println(
                Arrays.deepToString(
                        solution.floodFill(new int[][] {
                                {0, 0, 0},
                                {0, 0, 0},
                                {0, 0, 0}
                        }, 1, 1, 0)));
    }

}
