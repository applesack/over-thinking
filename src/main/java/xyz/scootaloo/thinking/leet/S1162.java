package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author AppleSack
 * @since 2023/03/13
 */
public class S1162 {

    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int[][] dist = new int[row][column];
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == 1) {
                    queue.offer(new int[] { r, c });
                    visited[r][c] = true;
                }
            }
        }

        int[][] directions = {
                { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
        };

        int max = 0;
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int r = position[0], c = position[1];
            int nextR, nextC;
            for (int[] d : directions) {
                nextR = r + d[0];
                nextC = c + d[1];
                if (nextR >= 0 && nextR < row && nextC >= 0 && nextC < column
                        && !visited[nextR][nextC]) {
                    dist[nextR][nextC] = dist[r][c] + 1;
                    if (dist[nextR][nextC] > max) {
                        max = dist[nextR][nextC];
                    }
                    queue.offer(new int[] { nextR, nextC });
                    visited[nextR][nextC] = true;
                }
            }
        }

        if (max == 0) {
            return -1;
        }
        return max;
    }

}
