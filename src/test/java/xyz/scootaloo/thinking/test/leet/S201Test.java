package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S201;

/**
 * @author AppleSack
 * @since 2023/03/07
 */
public class S201Test {

    private final S201 solution = new S201();

    @Test
    public void test() {
        System.out.println(solution.rangeBitwiseAnd(5, 7));
        System.out.println(solution.rangeBitwiseAnd(0, 0));
        System.out.println(solution.rangeBitwiseAnd(2147483647, 2147483647));
    }

}
