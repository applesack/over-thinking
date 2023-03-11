package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/10
 */
public class S695 {

    private boolean[][] visited;
    private int[][]     grid;
    private int         row;
    private int         column;

    public int maxAreaOfIsland(int[][] grid) {
        this.row = grid.length;
        this.column = grid[0].length;
        this.visited = new boolean[row][column];
        this.grid = grid;

        int ans = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (!visited[r][c] && grid[r][c] == 1) {
                    ans = Math.max(ans, backtrack(r, c));
                }
            }
        }
        return ans;
    }

    private final int[][] DIRECTIONS = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };

    private int backtrack(int r, int c) {
        if (isOverBound(r, c) || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;
        int nextR, nextC;
        int count = 1;
        for (int[] d : DIRECTIONS) {
            nextR = r + d[0];
            nextC = c + d[1];
            count += backtrack(nextR, nextC);
        }
        return count;
    }

    private boolean isOverBound(int r, int c) {
        return r >= row || r < 0 || c >= column || c < 0;
    }

}
