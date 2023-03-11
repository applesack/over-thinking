package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/10
 */
public class S1254 {

    private int[][]     grid;
    private boolean[][] visited;
    private int         row;
    private int         column;

    public int closedIsland(int[][] grid) {
        this.row = grid.length;
        this.column = grid[0].length;
        this.visited = new boolean[this.row][this.column];
        this.grid = grid;

        for (int r = 0; r < row; r++) {
            if (!visited[r][0] && grid[r][0] == 0) {
                backtrack(r, 0);
            }
            if (!visited[r][column - 1] && grid[r][column - 1] == 0) {
                backtrack(r, column - 1);
            }
        }
        for (int c = 0; c < column; c++) {
            if (!visited[0][c] && grid[0][c] == 0) {
                backtrack(0, c);
            }
            if (!visited[row - 1][c] && grid[row - 1][c] == 0) {
                backtrack(row - 1, c);
            }
        }

        int ans = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (visited[r][c] || grid[r][c] == 1) {
                    continue;
                }
                backtrack(r, c);
                ans++;
            }
        }
        return ans;
    }

    private final int[][] DIRECTIONS = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };

    private void backtrack(int r, int c) {
        if (isOverBound(r, c) || visited[r][c] || grid[r][c] == 1) {
            return;
        }
        grid[r][c] = 1;
        visited[r][c] = true;
        int nextR, nextC;
        for (int[] d : DIRECTIONS) {
            nextR = r + d[0];
            nextC = c + d[1];
            backtrack(nextR, nextC);
        }
    }

    private boolean isOverBound(int r, int c) {
        return r < 0 || r >= row || c < 0 || c >= column;
    }

}
