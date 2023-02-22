package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/21
 */
public class S200 {

    public int numIslands(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int ans = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    ans++;
                    dfs(R, C, r, c, grid, visited);
                }
            }
        }
        return ans;
    }

    // 上，右，下，左
    private final int[][] DIRECTION = new int[][] {
            { -1, 0 },
            { 0, 1 },
            { 1, 0 },
            { 0, -1 }
    };

    private void dfs(
            int R, int C, int r, int c, char[][] grid, boolean[][] visited) {
        if (r >= R || r < 0 || c < 0 || c >= C || grid[r][c] == '0') {
            return;
        }
        if (!visited[r][c]) {
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                dfs(R, C, r + DIRECTION[i][0], c + DIRECTION[i][1], grid, visited);
            }
        }
    }

}
