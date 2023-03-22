package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1557;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/22
 */
public class S1557Test {

    private final S1557 solution = new S1557();

    @Test
    public void test() {
        System.out.println(solution.findSmallestSetOfVertices(6, ToolBox.parse2dIntegerList("""
                [[0,1],[0,2],[2,5],[3,4],[4,2]]
                """))); // [0, 3]

        System.out.println(solution.findSmallestSetOfVertices(5, ToolBox.parse2dIntegerList("""
                [[0,1],[2,1],[3,1],[1,4],[2,4]]
                """))); // [0, 2, 3]
    }

}
