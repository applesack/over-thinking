package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S547;

/**
 * @author AppleSack
 * @since 2023/02/22
 */
public class S547Test {

    private final S547 solution = new S547();

    @Test
    public void test() {
        System.out.println(solution.findCircleNum(new int[][] {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 },
        }));
        System.out.println(solution.findCircleNum(new int[][] {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 },
        }));
    }

}
