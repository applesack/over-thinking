package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1624;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/17 - 9:47
 */
public class S1624Test {

    private final S1624 solution = new S1624();

    @Test
    public void test() {
        String input = "aa";
        System.out.println(solution.maxLengthBetweenEqualCharacters(input));
    }

    @Test
    public void test1() {
        String input = "abca";
        System.out.println(solution.maxLengthBetweenEqualCharacters(input));
    }

    @Test
    public void test2() {
        String input = "cbzxy";
        System.out.println(solution.maxLengthBetweenEqualCharacters(input));
    }

    @Test
    public void test3() {
        String input = "cabbac";
        System.out.println(solution.maxLengthBetweenEqualCharacters(input));
    }

    @Test
    public void test4() {
        String input = "mgntdygtxrvxjnwksqhxuxtrv";
        System.out.println(solution.maxLengthBetweenEqualCharacters(input));
    }

}
