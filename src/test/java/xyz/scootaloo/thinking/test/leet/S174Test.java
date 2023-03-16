package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S174;
import xyz.scootaloo.thinking.tool.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/13
 */
public class S174Test {

    private final S174 solution = new S174();

    @Test
    public void test() {
        System.out.println(solution.calculateMinimumHP(ToolBox.parse2dIntArray("""
                [[-2,-3,3],[-5,-10,1],[10,30,-5]]
                """)));
    }

}
