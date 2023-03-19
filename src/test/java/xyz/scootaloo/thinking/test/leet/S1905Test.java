package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1905;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/11
 */
public class S1905Test {

    private final S1905 solution = new S1905();

    @Test
    public void test() {
        System.out.println(solution.countSubIslands(ToolBox.parse2dIntArray("""
                [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]
                """), ToolBox.parse2dIntArray("""
                [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
                """)));

        System.out.println(solution.countSubIslands(ToolBox.parse2dIntArray("""
                [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]
                """), ToolBox.parse2dIntArray("""
                [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
                """)));
    }

}
