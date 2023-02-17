package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1784;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/03 - 8:42
 */
public class S1784Test {

    private final S1784 solution = new S1784();

    @Test
    public void test() {
        System.out.println(solution.checkOnesSegment("1001"));
        System.out.println(solution.checkOnesSegment("1100"));
        System.out.println(solution.checkOnesSegment("1000"));
        System.out.println(solution.checkOnesSegment("0110"));
        System.out.println(solution.checkOnesSegment("0110"));
        System.out.println(solution.checkOnesSegment("0101"));
    }

}
