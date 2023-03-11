package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/11
 */
public class S1020 {

    private int[][]     grid;
    private boolean[][] visited;
    private int         row;
    private int         column;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        row = grid.length;
        column = grid[0].length;
        visited = new boolean[row][column];

        for (int r = 0; r < row; r++) {
            if (!visited[r][0] && grid[r][0] == 1) {
                render(r, 0);
            }
            if (!visited[r][column - 1] && grid[r][column - 1] == 1) {
                render(r, column - 1);
            }
        }

        for (int c = 0; c < column; c++) {
            if (!visited[0][c] && grid[0][c] == 1) {
                render(0, c);
            }
            if (!visited[row - 1][c] && grid[row - 1][c] == 1) {
                render(row - 1, c);
            }
        }

        int ans = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private final int[][] DIRECTIONS = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };

    private void render(int r, int c) {
        if (isOverBound(r, c) || visited[r][c] || grid[r][c] == 0) {
            return;
        }
        grid[r][c] = 0;
        visited[r][c] = true;
        int nextR, nextC;
        for (int[] d : DIRECTIONS) {
            nextR = r + d[0];
            nextC = c + d[1];
            render(nextR, nextC);
        }
    }

    private boolean isOverBound(int r, int c) {
        return r < 0 || r >= row || c < 0 || c >= column;
    }

}
