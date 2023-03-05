package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S91;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S91Test {

    private final S91 solution = new S91();

    @Test
    public void test() {
        System.out.println(solution.numDecodings("12"));   // 2
        System.out.println(solution.numDecodings("226"));  // 3
        System.out.println(solution.numDecodings("306"));  // 0
        System.out.println(solution.numDecodings("2026")); // 2
        System.out.println(solution.numDecodings("2101")); // 1
    }

}
