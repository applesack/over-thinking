package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1319;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/16
 */
public class S1319Test {

    private final S1319 solution = new S1319();

    @Test
    public void test() {
        System.out.println(solution.makeConnected(4, ToolBox.parse2dIntArray("""
                [[0,1],[0,2],[1,2]]
                """))); // 1

        System.out.println(solution.makeConnected(6, ToolBox.parse2dIntArray("""
                [[0,1],[0,2],[0,3],[1,2],[1,3]]
                """))); // 2

        System.out.println(solution.makeConnected(6, ToolBox.parse2dIntArray("""
                [[0,1],[0,2],[0,3],[1,2]]
                """))); // -1

        System.out.println(solution.makeConnected(5, ToolBox.parse2dIntArray("""
                [[0,1],[0,2],[3,4],[2,3]]
                """))); // 0
    }

    @Test
    public void test1() {
        System.out.println(solution.makeConnected(5, ToolBox.parse2dIntArray("""
                [[0,1],[0,2],[3,4],[2,3]]
                """))); // 0
    }

}
