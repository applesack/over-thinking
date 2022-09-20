package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1608;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/12 - 9:17
 */
public class S1608Test {

    private final S1608 solution = new S1608();

    @Test
    public void test() {
//        System.out.println(solution.specialArray(new int[] { 3, 5 }));
        System.out.println(solution.specialArray(new int[] { 0, 0 }));
    }

    @Test
    public void test1() {
        int[] input = { 3, 6, 7, 7, 0 };
        System.out.println(solution.specialArray(input));
    }

}
