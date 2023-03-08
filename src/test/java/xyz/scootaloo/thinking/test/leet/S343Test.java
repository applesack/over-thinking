package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S343;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S343Test {

    private final S343 solution = new S343();

    @Test
    public void test() {
        System.out.println(solution.integerBreak(0)); // 0
        System.out.println(solution.integerBreak(1)); // 1
        System.out.println(solution.integerBreak(2)); // 1
        System.out.println(solution.integerBreak(3));
        System.out.println(solution.integerBreak(4));
        System.out.println(solution.integerBreak(5));
        System.out.println(solution.integerBreak(6));
        System.out.println(solution.integerBreak(7));
        System.out.println(solution.integerBreak(8));
        System.out.println(solution.integerBreak(9));
        System.out.println(solution.integerBreak(10));
    }

}
