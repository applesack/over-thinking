package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S831;

/**
 * @author AppleSack
 * @since 2023/04/01
 */
public class S831Test {

    private final S831 solution = new S831();

    @Test
    public void test() {
        System.out.println(solution.maskPII("LeetCode@LeetCode.com"));
        System.out.println(solution.maskPII("AB@qq.com"));
        System.out.println(solution.maskPII("1(234)567-890"));
        System.out.println(solution.maskPII("86-(10)12345678"));
    }

}
