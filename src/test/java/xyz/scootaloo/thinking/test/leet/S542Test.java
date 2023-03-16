package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S542;
import xyz.scootaloo.thinking.tool.ToolBox;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/03/13
 */
public class S542Test {

    private final S542 solution = new S542();

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(solution.updateMatrix(ToolBox.parse2dIntArray("""
                [[0,0,0],[0,1,0],[0,0,0]]
                """))));

        System.out.println(Arrays.deepToString(solution.updateMatrix(ToolBox.parse2dIntArray("""
                [[0,0,0],[0,1,0],[1,1,1]]
                """))));
    }

}
