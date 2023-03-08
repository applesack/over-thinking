package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S413;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S413Test {

    private final S413 solution = new S413();

    @Test
    public void test() {
        System.out.println(solution.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 })); // 3
        System.out.println(solution.numberOfArithmeticSlices(new int[] { 1 })); // 0
    }

}
