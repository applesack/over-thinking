package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S526;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/08 - 10:24
 */
public class S526Test {

    private final S526 solution = new S526();

    @Test
    public void test() {
        System.out.println(solution.countArrangement(1));
        System.out.println(solution.countArrangement(2));
        System.out.println(solution.countArrangement(3));
        System.out.println(solution.countArrangement(4));
    }

}
