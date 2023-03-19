package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S802;
import xyz.scootaloo.thinking.tool.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/18
 */
public class S802Test {

    private final S802 solution = new S802();

    @Test
    public void test() {
        System.out.println(solution.eventualSafeNodes(ToolBox.parse2dIntArray("""
                [[1,2],[2,3],[5],[0],[5],[],[]]
                """))); // [2, 4, 5, 6]

        System.out.println(solution.eventualSafeNodes(ToolBox.parse2dIntArray("""
                [[1,2,3,4],[1,2],[3,4],[0,4],[]]
                """))); // [4]
    }

}
