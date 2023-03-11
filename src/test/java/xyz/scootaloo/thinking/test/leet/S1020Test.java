package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1020;
import xyz.scootaloo.thinking.tool.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/11
 */
public class S1020Test {

    private final S1020 solution = new S1020();

    @Test
    public void test() {
        System.out.println(solution.numEnclaves(ToolBox.parse2dIntArray("""
                [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
                """)));

        System.out.println(solution.numEnclaves(ToolBox.parse2dIntArray("""
                [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
                """)));
    }

}
