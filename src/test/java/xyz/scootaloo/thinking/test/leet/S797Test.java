package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S797;

/**
 * @author AppleSack
 * @since 2023/03/08
 */
public class S797Test {

    private final S797 solution = new S797();

    @Test
    public void test() {
        System.out.println(solution.allPathsSourceTarget(new int[][] {
                { 1, 2 },
                { 3 },
                { 3 },
                {}
        }));
        System.out.println(solution.allPathsSourceTarget(new int[][] {
                { 4, 3, 1 },
                { 3, 2, 4 },
                { 3 },
                { 4 },
                {}
        }));
        System.out.println(solution.allPathsSourceTarget(new int[][] {
                { 4, 3, 1 },
                { 3, 2, 4 },
                { 3 },
                {},
                { 4 },
                {}
        }));
    }

    @Test
    public void test1() {
        System.out.println(solution.allPathsSourceTarget(new int[][] {
                { 4, 3, 1 },
                { 3, 2, 4 },
                {},
                { 4 },
                {}
        }));
    }

}
