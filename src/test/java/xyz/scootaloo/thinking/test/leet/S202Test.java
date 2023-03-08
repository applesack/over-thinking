package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S202;

/**
 * @author AppleSack
 * @since 2023/03/07
 */
public class S202Test {

    private final S202 solution = new S202();

    @Test
    public void test() {
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(2));
    }

}
