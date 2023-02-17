package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S6192;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/02 - 10:34
 */
public class S6192Test {

    private final S6192 solution = new S6192();

    @Test
    public void test() {
        System.out.println(solution.commonFactors(12, 6));
        System.out.println(solution.commonFactors(25, 30));
    }

}
