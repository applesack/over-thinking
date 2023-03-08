package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S583;

/**
 * @author AppleSack
 * @since 2023/03/08
 */
public class S583Test {

    private final S583 solution = new S583();

    @Test
    public void test() {
        System.out.println(solution.minDistance("sea", "eat"));
        System.out.println(solution.minDistance("leetcode", "etco"));
    }

    @Test
    public void test1() {
        System.out.println(solution.minDistance("leetcode", "etco"));
    }

}
