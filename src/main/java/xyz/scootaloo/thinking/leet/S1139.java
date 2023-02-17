package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S1139 {

    public int largest1BorderedSquare(int[][] grid) {
        int max = 0;
        int R = grid.length;
        int C = grid[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }
                int len = square(grid, r, c);
                if (len > max) {
                    max = len;
                }
                if (C - c < len) {
                    break;
                }
            }
        }
        return max * max;
    }

    private int square(int[][] grid, int R, int C) {
        int c = C;
        while (c < grid[0].length && grid[R][c] == 1) {
            c++;
        }
        c--;
        for (; c > C; c--) {
            int len = c - C + 1;
            boolean ok = true;
            if (R + len - 1 >= grid.length) {
                continue;
            }
            for (int i = 1; i < len; i++) {
                // 上边确定有效, 接下来比较右边, 下边和左边
                boolean local = grid[R + len - 1][C + i] == 1 // 下
                        && grid[R + i][C] == 1 && // 左
                        grid[R + i][C + len - 1] == 1; // 右
                if (!local) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return len;
            }
        }
        return 1;
    }

}
