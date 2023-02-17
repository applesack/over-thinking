package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S10;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S10Test {

    private final S10 solution = new S10();

    @Test
    public void test() {
        System.out.println(solution.isMatch("aab", "c*a*b"));
    }

}
