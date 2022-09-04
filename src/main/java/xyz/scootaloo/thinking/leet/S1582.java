package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/04 - 9:07
 */
public class S1582 {

    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;

        boolean[] rowSet = new boolean[row];
        boolean[] colSet = new boolean[column];

        int[] dp = new int[column];
        int zeroCount;

        for (int r = 0; r < row; r++) {
            zeroCount = 0;
            for (int c = 0; c < column; c++) {
                if (mat[r][c] == 1) {
                    zeroCount++;
                }
                dp[c] += mat[r][c];
            }
            if (zeroCount == 1) {
                rowSet[r] = true;
            }
        }

        for (int c = 0; c < column; c++) {
            if (dp[c] == 1) {
                colSet[c] = true;
            }
        }

        zeroCount = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (mat[r][c] == 1 && rowSet[r] && colSet[c]) {
                    zeroCount++;
                    break;
                }
            }
        }

        return zeroCount;
    }

}
