package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S322;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S322Test {

    private final S322 solution = new S322();

    @Test
    public void test() {
        System.out.println(solution.coinChange(new int[] { 1, 2, 5 }, 11)); // 3
        System.out.println(solution.coinChange(new int[] { 2 }, 3));        // -1
        System.out.println(solution.coinChange(new int[] { 1 }, 0));        // 0
        System.out.println(solution.coinChange(new int[] { 186, 419, 83, 408 }, 6249));        // 20
    }

}
