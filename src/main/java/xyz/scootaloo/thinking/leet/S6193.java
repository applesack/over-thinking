package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/02 - 10:37
 */
public class S6193 {

    public int maxSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        int max = 0, current;
        for (int r = 0; r<=(row-3); r++) {
            for (int c = 0; c<=(column - 3); c++) {
                current = grid[r][c] + grid[r][c + 1] + grid[r][c + 2] +
                        grid[r + 1][c + 1] +
                        grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2];
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }

}
