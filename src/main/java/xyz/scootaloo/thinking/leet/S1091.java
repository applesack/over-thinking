package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author AppleSack
 * @since 2023/02/23
 */
public class S1091 {

    private static final int[][] directions = {
            { 0, 1 }, { 0, -1 }, { 1, -1 }, { 1, 0 },
            { 1, 1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        if (grid[0][0] == 1 || grid[len - 1][len - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        grid[0][0] = 1;

        while (!queue.isEmpty() && grid[len - 1][len - 1] == 0) {
            int[] cur = queue.remove();
            int preLen = grid[cur[0]][cur[1]];
            for (int i = 0; i < 8; i++) {
                int newR = cur[0] + directions[i][0];
                int newC = cur[1] + directions[i][1];
                if (inBound(len, newR, newC) && grid[newR][newC] == 0) {
                    queue.add(new int[] { newR, newC });
                    grid[newR][newC] = preLen + 1;
                }
            }
        }
        return grid[len - 1][len - 1] == 0 ? -1 : grid[len - 1][len - 1];
    }

    private boolean inBound(int len, int r, int c) {
        return r >= 0 && c >= 0 && r < len && c < len;
    }

}
