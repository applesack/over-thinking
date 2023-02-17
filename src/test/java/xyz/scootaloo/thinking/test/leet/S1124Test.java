package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1124;

/**
 * @author AppleSack
 * @since 2023/02/14
 */
public class S1124Test {

    private final S1124 solution = new S1124();

    @Test
    public void test() {
        System.out.println(solution.longestWPI(new int[] { 9, 9, 6, 0, 6, 6, 9 }));
        System.out.println(solution.longestWPI(new int[] { 6, 6, 6 }));
    }

}
