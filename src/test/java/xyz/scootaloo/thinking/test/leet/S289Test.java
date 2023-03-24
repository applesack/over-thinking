package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S289;
import xyz.scootaloo.thinking.utils.ToolBox;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/03/23
 */
public class S289Test {

    private final S289 solution = new S289();

    @Test
    public void test() {
        System.out.println(io("""
                [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
                """)); // [[0, 0, 0], [1, 0, 1], [0, 1, 1], [0, 1, 0]]

        System.out.println(io("""
                [[1,1],[1,0]]
                """)); // [[1, 1], [1, 1]]
    }

    private String io(String text) {
        int[][] input = ToolBox.parse2dIntArray(text);
        solution.gameOfLife(input);
        return Arrays.deepToString(input);
    }

}
