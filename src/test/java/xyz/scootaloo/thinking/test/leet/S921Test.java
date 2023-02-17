package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S921;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/04 - 18:04
 */
public class S921Test {

    private final S921 solution = new S921();

    @Test
    public void test() {
        System.out.println(solution.minAddToMakeValid("())"));
        System.out.println(solution.minAddToMakeValid("((("));
        System.out.println(solution.minAddToMakeValid("()))(("));
    }

}
