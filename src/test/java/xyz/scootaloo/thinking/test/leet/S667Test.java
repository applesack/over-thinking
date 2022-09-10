package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S667;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/08 - 19:15
 */
public class S667Test {

    private final S667 solution = new S667();

    @Test
    public void test() {
        System.out.println(Arrays.toString(solution.constructArray(3, 1)));
        System.out.println(Arrays.toString(solution.constructArray(6, 2)));
        System.out.println(Arrays.toString(solution.constructArray(6, 3)));
        System.out.println(Arrays.toString(solution.constructArray(6, 4)));
    }

}
