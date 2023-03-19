package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1926;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author AppleSack
 * @since 2023/03/16
 */
public class S1926Test {

    private final S1926 solution = new S1926();

    @Test
    public void test() {
        System.out.println(solution.nearestExit(ToolBox.parse2dCharArray("""
                [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]]
                """), new int[] { 1, 2 })); // 1

        System.out.println(solution.nearestExit(ToolBox.parse2dCharArray("""
                [["+","+","+"],[".",".","."],["+","+","+"]]
                """), new int[] { 1, 0 })); // 2

        System.out.println(solution.nearestExit(ToolBox.parse2dCharArray("""
                [[".","+"]]
                """), new int[] { 0, 0 })); // -1
    }

}
