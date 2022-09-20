package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S670;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/13 - 8:10
 */
public class S670Test {

    private final S670 solution = new S670();

    @Test
    public void test() {
        System.out.println(solution.maximumSwap(2736));
        System.out.println(solution.maximumSwap(9973));
    }

    @Test
    public void test1() {
        //                                           9
        System.out.println(solution.maximumSwap(98368));
        System.out.println(solution.maximumSwap(115));
    }

    @Test
    public void test2() {
        System.out.println(solution.maximumSwap(10909091));
    }

}
