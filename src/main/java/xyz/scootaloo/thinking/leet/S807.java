package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 20:28
 */
public class S807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        int[] leftView = new int[row];
        int[] topView = new int[column];

        int point;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                point = grid[r][c];
                if (point > leftView[r]) {
                    leftView[r] = point;
                }
                if (point > topView[c]) {
                    topView[c] = point;
                }
            }
        }

        int sum = 0, diff;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                diff = Math.min(leftView[r], topView[c]) - grid[r][c];
                if (diff != 0) {
                    sum += diff;
                }
            }
        }

        return sum;
    }

}
