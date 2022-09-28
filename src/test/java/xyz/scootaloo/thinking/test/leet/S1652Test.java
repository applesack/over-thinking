package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1652;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/24 - 15:44
 */
public class S1652Test {

    private final S1652 solution = new S1652();

    @Test
    public void test() {
        System.out.println(Arrays.toString(solution.decrypt(new int[] { 5, 7, 1, 4 }, 3)));
    }

    @Test
    public void test1() {
        System.out.println(Arrays.toString(solution.decrypt(new int[] { 2, 4, 9, 3 }, -2)));
    }

}
