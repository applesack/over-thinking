package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1254;
import xyz.scootaloo.thinking.tool.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/10
 */
public class S1254Test {

    private final S1254 solution = new S1254();

    @Test
    public void test() {
        System.out.println(solution.closedIsland(new int[][] {
                { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 0 },
                { 1, 0, 1, 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0 }
        }));

        System.out.println(solution.closedIsland(
                ToolBox.parse2dIntArray("""
                        [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
                        """)));

        System.out.println(solution.closedIsland(
                ToolBox.parse2dIntArray("""
                        [[1,1,1,1,1,1,1],
                        [1,0,0,0,0,0,1],
                        [1,0,1,1,1,0,1],
                        [1,0,1,0,1,0,1],
                        [1,0,1,1,1,0,1],
                        [1,0,0,0,0,0,1],
                        [1,1,1,1,1,1,1]]
                                   """)));

        System.out.println(solution.closedIsland(
                ToolBox.parse2dIntArray("""
                        [[0,0,1,1,0,1,0,0,1,0],
                         [1,1,0,1,1,0,1,1,1,0],
                         [1,0,1,1,1,0,0,1,1,0],
                         [0,1,1,0,0,0,0,1,0,1],
                         [0,0,0,0,0,0,1,1,1,0],
                         [0,1,0,1,0,1,0,1,1,1],
                         [1,0,1,0,1,1,0,0,0,1],
                         [1,1,1,1,1,1,0,0,0,0],
                         [1,1,1,0,0,1,0,1,0,1],
                         [1,1,1,0,1,1,0,1,1,0]]
                         """)));
    }

}
