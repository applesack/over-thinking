package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1092;

/**
 * @author AppleSack
 * @since 2023/03/28
 */
public class S1092Test {

    private final S1092 solution = new S1092();

    @Test
    public void test() {
        System.out.println(solution.shortestCommonSupersequence("cab", "abac"));
    }

}
