package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1598;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/09 - 8:13
 */
public class S1598Test {

    private final S1598 solution = new S1598();

    @Test
    public void test() {
        System.out.println(solution.minOperations(new String[] { "d1/", "d2/", "../", "d21/", "./" }));
        System.out.println(solution.minOperations(new String[] { "d1/", "d2/", "./", "d3/", "../", "d31/" }));
        System.out.println(solution.minOperations(new String[] { "d1/", "../", "../", "../" }));
    }

}
