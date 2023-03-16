package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S417;
import xyz.scootaloo.thinking.tool.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/13
 */
public class S417Test {

    private final S417 solution = new S417();

    @Test
    public void test() {
        System.out.println(solution.pacificAtlantic(ToolBox.parse2dIntArray("""
                [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
                """)));
    }

}
