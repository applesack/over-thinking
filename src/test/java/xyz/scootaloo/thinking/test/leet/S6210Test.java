package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S6210;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/15 - 23:19
 */
public class S6210Test {

    private final S6210 solution = new S6210();

    @Test
    public void test() {
        System.out.println(solution.minimizeArrayValue(new int[] { 3, 7, 1, 6 })); // 5
        System.out.println(solution.minimizeArrayValue(new int[] { 10, 1 })); // 10
        System.out.println(solution.minimizeArrayValue(new int[] { 6, 9, 3, 8, 14 })); // 8
        //
    }

}
