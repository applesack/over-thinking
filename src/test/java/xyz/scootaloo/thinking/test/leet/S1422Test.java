package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1422;

/**
 * @author flutterdash@qq.com
 * @since 2022/8/14 下午3:11
 */
public class S1422Test {

    private final S1422 solution = new S1422();

    @Test
    public void test() {
        String s = "011101";
        assert solution.maxScore(s) == 5;
    }

    @Test
    public void test1() {
        String s = "00111";
        assert solution.maxScore(s) == 5;
    }

    @Test
    public void test2() {
        String s = "1111";
        assert solution.maxScore(s) == 3;
    }

}
