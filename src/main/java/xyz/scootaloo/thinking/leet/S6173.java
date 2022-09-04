package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/03 - 23:17
 */
public class S6173 {

    private int max = 0;
    private boolean[] zeroRows;
    private int row;
    private int column;

    public int maximumRows(int[][] mat, int cols) {
        row = mat.length;
        column = mat[0].length;

        zeroRows = new boolean[mat.length];
        for (int r = 0; r < row; r++) {
            boolean zero = true;
            for (int c = 0; c < column; c++) {
                if (mat[r][c] == 1) {
                    zero = false;
                    break;
                }
            }
            if (zero) {
                zeroRows[r] = true;
            }
        }

        dfs(mat, new boolean[column], cols, 0);
        return max;
    }

    private void dfs(int[][] mat, boolean[] selected, int rest, int pos) {
        int result = 0;
        for (int r = 0; r < row; r++) {
            boolean broken = false;
            if (zeroRows[r]) {
                result++;
                continue;
            }

            for (int c = 0; c < column; c++) {
                if (mat[r][c] == 1 && !selected[c]) {
                    broken = true;
                    break;
                }
            }

            if (!broken) {
                result++;
            }
        }

        if (rest == 0) {
            if (result > max) {
                max = result;
            }
            return;
        }

        for (int i = pos; i < column; i++) {
            if (!selected[i]) {
                selected[i] = true;
                dfs(mat, selected, rest - 1, i + 1);
                selected[i] = false;
            }
        }
    }

}
