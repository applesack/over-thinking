package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1694;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/01 - 9:55
 */
public class S1694Test {

    private final S1694 solution = new S1694();

    @Test
    public void test() {
        System.out.println(solution.reformatNumber("1-23-45 6"));
        System.out.println(solution.reformatNumber("123 4-567"));
        System.out.println(solution.reformatNumber("123 4-5678"));
        System.out.println(solution.reformatNumber("12"));
    }

}
