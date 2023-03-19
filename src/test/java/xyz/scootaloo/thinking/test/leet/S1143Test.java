package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1143;

/**
 * @author AppleSack
 * @since 2023/03/06
 */
public class S1143Test {

    private final S1143 solution = new S1143();

    @Test
    public void test() {
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }

}
