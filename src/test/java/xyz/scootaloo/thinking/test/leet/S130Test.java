package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S130;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/02/24
 */
public class S130Test {

    private final S130 solution = new S130();

    @Test
    public void test() {
        char[][] board = {
                "XXXX".toCharArray(),
                "XOOX".toCharArray(),
                "XXOX".toCharArray(),
                "XOXX".toCharArray(),
        };
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    @Test
    public void test1() {
        char[][] board = {
                "X".toCharArray()
        };
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

}
