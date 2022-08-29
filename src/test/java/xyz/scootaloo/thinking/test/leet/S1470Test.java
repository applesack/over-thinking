package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1470;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/29 - 8:58
 */
public class S1470Test {

    private final S1470 solution = new S1470();

    @Test
    public void test() {
        int[] input = {2, 5, 1, 3, 4, 7};
        System.out.println(Arrays.toString(solution.shuffle(input, 3)));
    }

    @Test
    public void test1() {
        int[] input = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(Arrays.toString(solution.shuffle(input, 4)));
    }

}
