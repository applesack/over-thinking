package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.utils.Mark;

/**
 * @author AppleSack
 * @since 2023/03/13
 */
@Mark("todo")
public class S174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] dp = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (r == 0 && c == 0) {
                    dp[r][c] = dungeon[r][c];
                } else if (r == 0) {
                    dp[r][c] = dungeon[r][c] + dp[r][c - 1];
                } else if (c == 0) {
                    dp[r][c] = dungeon[r][c] + dp[r - 1][c];
                } else {
                    dp[r][c] = dungeon[r][c] + Math.min(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }
        return dungeon[row - 1][column - 1];
    }

}
