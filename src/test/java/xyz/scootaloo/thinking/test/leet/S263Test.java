package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S263;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/28 - 9:06
 */
public class S263Test {

    private final S263 solution = new S263();

    @Test
    public void test() {
        System.out.println(solution.isUgly(6));
        System.out.println(solution.isUgly(1));
        System.out.println(solution.isUgly(14));
    }

}
