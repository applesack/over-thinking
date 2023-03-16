package xyz.scootaloo.thinking.leet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author AppleSack
 * @since 2023/03/13
 */
public class S417 {

    private int     row;
    private int     column;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        column = heights[0].length;
        this.heights = heights;
        boolean[][] a = bfs(true), b = bfs(false);
        List<List<Integer>> result = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (a[r][c] && b[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private static final int[][] DIRECTIONS = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };

    private boolean[][] bfs(boolean left) {
        int len = row + column;
        int r = 0, c = column - 1;
        boolean[][] visited = new boolean[row][column];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < len; i++) {
            queue.offer(new int[] { r, c });
            visited[r][c] = true;
            if (left) {
                if (c > 0) {
                    c--;
                } else {
                    r++;
                }
            } else {
                if (r < row - 1) {
                    r++;
                } else {
                    c--;
                }
            }
        }

        int nextR, nextC;
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            r = position[0];
            c = position[1];
            for (int[] d : DIRECTIONS) {
                nextR = r + d[0];
                nextC = c + d[1];
                if (nextR >= 0 && nextR < row && nextC >= 0 &&
                        nextC < column && !visited[nextR][nextC]) {
                    if (heights[nextR][nextC] >= heights[r][c]) {
                        visited[nextR][nextC] = true;
                        queue.offer(new int[] { nextR, nextC });
                    }
                }
            }
        }
        return visited;
    }

}
