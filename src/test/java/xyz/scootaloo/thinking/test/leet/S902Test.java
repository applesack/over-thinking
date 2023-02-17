package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S902;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/18 - 9:12
 */
public class S902Test {

    private final S902 solution = new S902();

    @Test
    public void test() {
        // 1   3  5  7  4
        // 11 13 15 17  4
        // 31 33 35 37  4
        // 51 53 55 57  4
        // 71 73 75 77  4
        String[] input = { "1", "3", "5", "7" };
        System.out.println(solution.atMostNGivenDigitSet(input, 100));
    }

    @Test
    public void test1() {
        String[] input = { "1", "4", "9" };
        System.out.println(solution.atMostNGivenDigitSet(input, 1000000000));
    }

    @Test
    public void test2() {
        String[] input = { "7" };
        System.out.println(solution.atMostNGivenDigitSet(input, 8));
    }

    @Test
    public void test3() {
        String[] input = { "5", "6" };
        System.out.println(solution.atMostNGivenDigitSet(input, 19));
    }

    @Test
    public void test4() {
        System.out.println(solution.atMostNGivenDigitSet(new String[] { "1", "3", "5", "7" }, 100));
        System.out.println(solution.atMostNGivenDigitSet(new String[] { "1", "4", "9" }, 1000000000));
        System.out.println(solution.atMostNGivenDigitSet(new String[] { "7" }, 8));
        System.out.println(solution.atMostNGivenDigitSet(new String[] { "5", "6" }, 19));
        System.out.println(solution.atMostNGivenDigitSet(new String[] { "5", "7", "8" }, 59));

    }

}
