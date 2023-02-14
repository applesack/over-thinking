package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S6208;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/15 - 22:38
 */
public class S6208Test {

    private final S6208 solution = new S6208();

    @Test
    public void test() {
        System.out.println(solution.countTime("0?:0?"));
        System.out.println(solution.countTime("?5:00"));
        System.out.println(solution.countTime("??:??"));
        System.out.println(solution.countTime("07:?3"));
        System.out.println(solution.countTime("23:23"));
    }

}
