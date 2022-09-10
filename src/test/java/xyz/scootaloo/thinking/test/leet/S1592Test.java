package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1592;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 7:58
 */
public class S1592Test {

    private final S1592 solution = new S1592();

    @Test
    public void test() {
        String input = "  this   is  a sentence ";
        System.out.println(solution.reorderSpaces(input));
    }

    @Test
    public void test1() {
        String input = " practice   makes   perfect";
        System.out.println(solution.reorderSpaces(input));
    }

    @Test
    public void test2() {
        String input = "  walks  udp package   into  bar a";
        System.out.println(solution.reorderSpaces(input));
    }

    @Test
    public void test3() {
        String input = "a";
        System.out.println(solution.reorderSpaces(input));
    }

}
