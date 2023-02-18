package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1237;
import xyz.scootaloo.thinking.leet.ds.CustomFunction;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
public class S1237Test {

    private final S1237 solution = new S1237();

    @Test
    public void test() {
        F1 f1 = new F1();
        System.out.println(solution.findSolution(f1, 5));
    }

    @Test
    public void test2() {
        F2 f2 = new F2();
        System.out.println(solution.findSolution(f2, 5));
    }

    private static class F1 implements CustomFunction {

        @Override
        public int f(int x, int y) {
            return x + y;
        }
    }

    private static class F2 implements CustomFunction {

        @Override
        public int f(int x, int y) {
            return x * y;
        }
    }

}
