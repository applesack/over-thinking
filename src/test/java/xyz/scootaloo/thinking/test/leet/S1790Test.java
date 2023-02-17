package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1790;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/11 - 8:25
 */
public class S1790Test {

    private final S1790 solution = new S1790();

    @Test
    public void test() {
        System.out.println(solution.areAlmostEqual("bank", "kanb"));
        System.out.println(solution.areAlmostEqual("attack", "defend"));
        System.out.println(solution.areAlmostEqual("kelb", "kelb"));
        System.out.println(solution.areAlmostEqual("abcd", "dcba"));
    }

}
