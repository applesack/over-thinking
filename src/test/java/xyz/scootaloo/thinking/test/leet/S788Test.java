package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S788;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/25 - 11:01
 */
public class S788Test {

    private final S788 solution = new S788();

    @Test
    public void test() {
        System.out.println(solution.rotatedDigits(1));
        System.out.println(solution.rotatedDigits(20));
        System.out.println(solution.rotatedDigits(30));
        System.out.println(solution.rotatedDigits(50));
        System.out.println(solution.rotatedDigits(100));
    }

}
