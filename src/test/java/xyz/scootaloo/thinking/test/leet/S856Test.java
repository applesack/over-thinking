package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S856;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/09 - 10:21
 */
public class S856Test {

    private final S856 solution = new S856();

    @Test
    public void test() {
        System.out.println(solution.scoreOfParentheses("()"));
        System.out.println(solution.scoreOfParentheses("(())"));
        System.out.println(solution.scoreOfParentheses("()()"));
        System.out.println(solution.scoreOfParentheses("(()(()))"));
    }

}
