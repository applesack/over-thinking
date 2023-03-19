package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/09
 */
public class S733 {

    private int[][]     image;
    private boolean[][] visited;
    private int         row;
    private int         column;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image;
        this.row = image.length;
        this.column = image[0].length;
        this.visited = new boolean[this.row][this.column];
        if (isOverBound(sr, sc)) {
            return image;
        }
        int value = image[sr][sc];
        dfs(sr, sc, value, color);
        return image;
    }

    private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void dfs(int r, int c, int value, int color) {
        if (isOverBound(r, c) || image[r][c] != value || visited[r][c]) {
            return;
        }
        image[r][c] = color;
        visited[r][c] = true;
        for (int[] direction : DIRECTIONS) {
            dfs(r + direction[0], c + direction[1], value, color);
        }
    }

    private boolean isOverBound(int r, int c) {
        return (r >= row) || (r < 0) || (c >= column) || (c < 0);
    }

}
