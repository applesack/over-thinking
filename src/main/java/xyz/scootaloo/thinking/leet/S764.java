package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/09 - 11:49
 */
public class S764 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        n += 2;
        boolean[][] grid = new boolean[n][n];
        for (int[] mine : mines) {
            grid[mine[0] + 1][mine[1] + 1] = true;
        }

        for (int r = 0; r<n; r++) {
            grid[r][0] = true;
            grid[r][n - 1] = true;
        }

        for (int c = 0; c<n; c++) {
            grid[0][c] = true;
            grid[n - 1][c] = true;
        }

        int[][] lens = new int[n][n];
        for (int r = 0; r<n; r++) {
            for (int c = 0; c<n; c++) {
                if (grid[r][c]) {
                    // 向右
                    for (int tc = c + 1, base = 1; tc<n; tc++, base++) {
                        if (grid[r][tc]) {
                            break;
                        }
                        if (lens[r][tc] == 0 || lens[r][tc] > base) {
                            lens[r][tc] = base;
                        }
                    }

                    // 向左
                    for (int tc = c - 1, base = 1; tc>=0; tc--, base++) {
                        if (tc != c && grid[r][tc]) {
                            break;
                        }
                        if (lens[r][tc] == 0 || lens[r][tc] > base) {
                            lens[r][tc] = base;
                        }
                    }

                    // 向上
                    for (int tr = r - 1, base = 1; tr >= 0; tr--, base++) {
                        if (grid[tr][c]) {
                            break;
                        }
                        if (lens[tr][c] == 0 || lens[tr][c] > base) {
                            lens[tr][c] = base;
                        }
                    }

                    // 向下
                    for (int tr = r + 1, base = 1; tr < n; tr++, base++) {
                        if (tr != r && grid[tr][c]) {
                            break;
                        }
                        if (lens[tr][c] == 0 || lens[tr][c] > base) {
                            lens[tr][c] = base;
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int r = 0; r<n; r++) {
            for (int c = 0; c<n; c++) {
                if (lens[r][c] > max) {
                    max = lens[r][c];
                }
            }
        }

        return max;
    }

}
