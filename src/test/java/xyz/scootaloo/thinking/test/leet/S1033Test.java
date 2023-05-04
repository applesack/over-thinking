package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1033;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/04/07
 */
public class S1033Test {

    private final S1033 solution = new S1033();

    @Test
    public void test() {
        System.out.println(Arrays.toString(solution.numMovesStones(1, 2, 5)));
        System.out.println(Arrays.toString(solution.numMovesStones(4, 3, 2)));
        System.out.println(Arrays.toString(solution.numMovesStones(3, 5, 1)));
    }

}
