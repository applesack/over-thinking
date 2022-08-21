package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S2194;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 14:24
 */
public class S2194Test {

    private final S2194 solution = new S2194();

    @Test
    public void test() {
        String pattern = "K1:L2";
        System.out.println(solution.cellsInRange(pattern));
    }

    @Test
    public void test2() {
        String pattern = "A1:F1";
        System.out.println(solution.cellsInRange(pattern));
    }

}
