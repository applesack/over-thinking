package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author AppleSack
 * @since 2023/03/13
 */
public class S542 {

    private int row, column;

    public int[][] updateMatrix(int[][] mat) {
        row = mat.length;
        column = mat[0].length;
        int[][] dist = new int[row][column];
        boolean[][] visited = new boolean[row][column];
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (mat[r][c] == 0) {
                    queue.offer(new int[] { r, c });
                    visited[r][c] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] zero = queue.poll();
            int r = zero[0], c = zero[1];
            for (int[] d : DIRECTIONS) {
                int nextR = r + d[0], nextC = c + d[1];
                if (!isOverBound(nextR, nextC) && !visited[nextR][nextC]) {
                    dist[nextR][nextC] = dist[r][c] + 1;
                    queue.add(new int[] { nextR, nextC });
                    visited[nextR][nextC] = true;
                }
            }
        }

        return dist;
    }

    private static final int[][] DIRECTIONS = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };

    private boolean isOverBound(int r, int c) {
        return r < 0 || r >= row || c < 0 || c >= column;
    }

}
