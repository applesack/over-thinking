package xyz.scootaloo.thinking.test.startagain.s1;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.startagain.s1.S1P704;

/**
 * @author applesack
 * @since 2022/12/23 - 15:34
 */
public class S1P704Test {

    private final S1P704 solution = new S1P704();

    @Test
    public void test() {
        int result = solution.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9);
        System.out.println(result);

        int result2 = solution.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2);
        System.out.println(result2);
    }

}
