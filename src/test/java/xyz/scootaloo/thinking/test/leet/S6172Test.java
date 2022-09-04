package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S6172;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/03 - 23:06
 */
public class S6172Test {

    private final S6172 solution = new S6172();

    @Test
    public void test() {
        System.out.println(solution.isStrictlyPalindromic(1));
        System.out.println(solution.isStrictlyPalindromic(2));
        System.out.println(solution.isStrictlyPalindromic(3));
        System.out.println(solution.isStrictlyPalindromic(4));
    }

}
