package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/11
 */
public class S1905 {

    private int[][]     grid1;
    private int[][]     grid2;
    private boolean[][] visited;
    private int         row;
    private int         column;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        row = grid1.length;
        column = grid1[0].length;
        visited = new boolean[row][column];

        int ans = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (!visited[r][c] && grid2[r][c] == 1 && backtrack(r, c)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private final int[][] DIRECTIONS = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };

    private boolean backtrack(int r, int c) {
        // logic:
        // 从一个点开始向四周搜索, 形成一个路径, 这个路径包含该封闭岛的所有区域
        // 在遍历的过程中, 如果遇到一个区域, 在grid1中不存在, 那么证明这个封闭岛不是grid1完全覆盖的子岛
        // 这种情况应该返回false
        if (isOverBound(r, c) || visited[r][c] || grid2[r][c] == 0) {
            return true;
        }
        boolean result = grid1[r][c] != 0;
        visited[r][c] = true;
        int nextR, nextC;
        for (int[] d : DIRECTIONS) {
            nextR = r + d[0];
            nextC = c + d[1];
            result = backtrack(nextR, nextC) && result;
        }

        return result;
    }

    private boolean isOverBound(int r, int c) {
        return r < 0 || r >= row || c < 0 || c >= column;
    }

}
