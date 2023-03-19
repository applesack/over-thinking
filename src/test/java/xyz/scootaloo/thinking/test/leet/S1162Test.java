package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1162;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/13
 */
public class S1162Test {

    private final S1162 solution = new S1162();

    @Test
    public void test() {
        System.out.println(solution.maxDistance(ToolBox.parse2dIntArray("""
                [[1,0,1],[0,0,0],[1,0,1]]
                """)));

        System.out.println(solution.maxDistance(ToolBox.parse2dIntArray("""
                [[1,0,0],[0,0,0],[0,0,0]]
                """)));

        System.out.println(solution.maxDistance(ToolBox.parse2dIntArray("""
                [[0,0,0],[0,0,0],[0,0,0]]
                """)));

        System.out.println(solution.maxDistance(ToolBox.parse2dIntArray("""
                [[1,1,1],[1,1,1],[1,1,1]]
                """)));
    }

}
