package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author AppleSack
 * @since 2023/03/14
 */
public class S1926 {

    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int column = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];
        queue.offer(entrance);

        int[][] directions = {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
        };

        int step = 0;
        int size = 1;
        int nextR, nextC;
        while (!queue.isEmpty()) {
            int nextSize = 0;
            step++;
            for (int i = 0; i < size; i++) {
                if (queue.isEmpty()) {
                    break;
                }
                int[] head = queue.poll();
                int r = head[0], c = head[1];
                if (visited[r][c]) {
                    visited[r][c] = true;
                    continue;
                }
                visited[r][c] = true;
                for (int[] d : directions) {
                    nextR = r + d[0];
                    nextC = c + d[1];
                    if (nextR >= 0 && nextR < row &&
                            nextC >= 0 && nextC < column &&
                            !visited[nextR][nextC]) {
                        if (maze[nextR][nextC] == '+') {
                            continue;
                        }
                        if (nextR == 0 || nextR == row - 1 || nextC == 0 || nextC == column - 1) {
                            return step;
                        }

                        queue.offer(new int[] { nextR, nextC });
                        nextSize++;
                    }
                }
            }
            size = nextSize;
        }
        return -1;
    }

}
