package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1466;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/18
 */
public class S1466Test {

    private final S1466 solution = new S1466();

    @Test
    public void test() {
        System.out.println(solution.minReorder(6, ToolBox.parse2dIntArray("""
                [[0,1],[1,3],[2,3],[4,0],[4,5]]
                """))); // 3

        System.out.println(solution.minReorder(5, ToolBox.parse2dIntArray("""
                [[1,0],[1,2],[3,2],[3,4]]
                """))); // 2

        System.out.println(solution.minReorder(3, ToolBox.parse2dIntArray("""
                [[1,0],[2,0]]
                """))); // 0
    }

}
