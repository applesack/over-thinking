package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S6194;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/02 - 11:03
 */
public class S6194Test {

    private final S6194 solution = new S6194();

    @Test
    public void test() {
        System.out.println(solution.minimizeXor(3, 5));
        System.out.println(solution.minimizeXor(1, 12));
        //
        System.out.println(solution.minimizeXor(25, 72)); // expect 24
    }

}
