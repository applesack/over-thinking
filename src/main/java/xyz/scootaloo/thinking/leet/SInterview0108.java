package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/30 - 13:34
 */
public class SInterview0108 {

    public void setZeroes(int[][] matrix) {
        final int row = matrix.length;
        if (row == 0) {
            return;
        }
        final int column = matrix[0].length;

        final boolean[] rowSet = new boolean[row];
        final boolean[] colSet = new boolean[column];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (matrix[r][c] == 0) {
                    rowSet[r] = true;
                    colSet[c] = true;
                }
            }
        }

        for (int r = 0; r < row; r++) {
            if (!rowSet[r]) {
                continue;
            }
            for (int c = 0; c < column; c++) {
                matrix[r][c] = 0;
            }
        }

        for (int c = 0; c < column; c++) {
            if (!colSet[c]) {
                continue;
            }
            for (int r = 0; r < row; r++) {
                matrix[r][c] = 0;
            }
        }
    }

}
