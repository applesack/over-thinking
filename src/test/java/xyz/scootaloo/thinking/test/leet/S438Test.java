package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S438;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
public class S438Test {

    private final S438 solution = new S438();

    @Test
    public void test() {
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("abab", "ab"));
    }

}
