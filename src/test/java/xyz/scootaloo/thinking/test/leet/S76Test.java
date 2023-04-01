package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S76;

/**
 * @author AppleSack
 * @since 2023/03/31
 */
public class S76Test {

    private final S76 solution = new S76();

    @Test
    public void test() {
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(solution.minWindow("a", "a")); // a
        System.out.println(solution.minWindow("a", "aa")); // ""
    }

}
