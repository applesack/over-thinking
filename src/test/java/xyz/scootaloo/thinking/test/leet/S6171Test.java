package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S6171;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/03 - 22:34
 */
public class S6171Test {

    private final S6171 solution = new S6171();

    @Test
    public void test() {
        int[] input = { 4, 2, 4 };
        System.out.println(solution.findSubarrays(input));
    }

    @Test
    public void test1() {
        int[] input = { 0, 0, 0 };
        System.out.println(solution.findSubarrays(input));
    }

}
