package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thking.leet.S927;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/06 - 20:33
 */
public class S927Test {

    private final S927 solution = new S927();

    @Test
    public void test() {
        System.out.println(Arrays.toString(solution.threeEqualParts(new int[] { 1, 0, 1, 0, 1 })));
        System.out.println(Arrays.toString(solution.threeEqualParts(new int[] { 1, 1, 0, 1, 1 })));
        System.out.println(Arrays.toString(solution.threeEqualParts(new int[] { 1, 1, 0, 0, 1 })));
    }

    @Test
    public void test1() {
        System.out.println(Arrays.toString(solution.threeEqualParts(new int[] { 0, 1, 0, 1, 1 })));
        System.out.println(Arrays.toString(solution.threeEqualParts(new int[] {
                1, 1, 1, 1, 1, 1, 0, 1, 1, 1
        })));
    }

    @Test
    public void test2() {
        //                                                                      0  1  2  3  4
        System.out.println(Arrays.toString(solution.threeEqualParts(new int[] { 1, 0, 1, 0, 1, 0 })));
        //                                                                      0  1  2  3  4  5  6  7  8
        System.out.println(Arrays.toString(solution.threeEqualParts(new int[] { 1, 0, 0, 1, 0, 0, 1, 0, 0 })));
    }

}
