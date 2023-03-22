package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S997;

/**
 * @author AppleSack
 * @since 2023/03/22
 */
public class S997Test {

    private final S997 solution = new S997();

    @Test
    public void test() {
        System.out.println(solution.findJudge(2, new int[][] {
                { 1, 2 }
        })); // 2

        System.out.println(solution.findJudge(3, new int[][] {
                { 1, 3 }, { 2, 3 }
        })); // 3

        System.out.println(solution.findJudge(3, new int[][] {
                { 1, 3 }, { 2, 3 }, { 3, 1 }
        })); // -1
    }

}
