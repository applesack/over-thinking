package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1638;

/**
 * @author AppleSack
 * @since 2023/03/27
 */
public class S1638Test {

    private final S1638 solution = new S1638();

    @Test
    public void test() {
        System.out.println(solution.countSubstrings("aba", "baba")); // 6
        System.out.println(solution.countSubstrings("ab", "bb")); // 3
        System.out.println(solution.countSubstrings("a", "a")); // 0
        System.out.println(solution.countSubstrings("abe", "bbc")); // 10
    }

    @Test
    public void test1() {
        System.out.println(solution.countSubstrings("ab", "bb")); // 3
    }

}
