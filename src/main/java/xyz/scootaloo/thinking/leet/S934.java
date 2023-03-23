package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author AppleSack
 * @since 2023/03/19
 */
public class S934 {

    private int[][]     grid;
    private boolean[][] visited;
    private int         row, column;

    public int shortestBridge(int[][] grid) {
        init(grid);
        List<List<int[]>> island = new ArrayList<>(2);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (!visited[r][c] && grid[r][c] == 1) {
                    island.add(findIsland(r, c));
                }
            }
        }

        return computeMinDistance(island.get(0), island.get(1));
    }

    private void init(int[][] grid) {
        this.grid = grid;
        row = grid.length;
        column = grid[0].length;
        visited = new boolean[row][column];
    }

    private static final int[][] DIRECTIONS = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };

    private List<int[]> findIsland(int r, int c) {
        List<int[]> result = new LinkedList<>();
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new int[] { r, c });
        int nextR, nextC, curR, curC;
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            curR = head[0];
            curC = head[1];
            boolean isLand = true;
            for (int[] d : DIRECTIONS) {
                nextR = curR + d[0];
                nextC = curC + d[1];
                if (nextR >= 0 && nextR < row &&
                        nextC >= 0 && nextC < column &&
                        !visited[nextR][nextC] && grid[nextR][nextC] == 1) {
                    visited[nextR][nextC] = true;
                    queue.offer(new int[] { nextR, nextC });
                } else {
                    isLand = false;
                }
            }
            if (!isLand) {
                result.add(head);
            }
        }
        return result;
    }

    private int computeMinDistance(List<int[]> a, List<int[]> b) {
        int min = Integer.MAX_VALUE;
        for (int[] aPosition : a) {
            for (int[] bPosition : b) {
                min = Math.min(min,
                        computeDistance(
                                aPosition[0], aPosition[1],
                                bPosition[0], bPosition[1]));
            }
        }
        return min;
    }

    private int computeDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2) - 1;
    }

}
