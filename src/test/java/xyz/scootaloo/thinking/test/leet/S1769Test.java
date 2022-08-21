package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1769;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 16:40
 */
public class S1769Test {

    private final S1769 solution = new S1769();

    @Test
    public void test() {
        String input = "001011";
        System.out.println(Arrays.toString(solution.minOperations(input)));
    }

}
