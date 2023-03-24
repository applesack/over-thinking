package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.utils.mark.Tag;

/**
 * @author AppleSack
 * @since 2023/03/23
 */
@Tag("状态压缩")
public class S289 {

    private static final int[][] DIRECTIONS = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 },
            { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 }
    };

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int column = board[0].length;
        int nextR, nextC, liveCount;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                liveCount = 0;
                for (int[] d : DIRECTIONS) {
                    nextR = r + d[0];
                    nextC = c + d[1];
                    // 0 当前是死的
                    // 1 当前是活的
                    // 2 当前是活的，下一轮死
                    // 3 当前是死的，下一轮活
                    if (nextR < 0 || nextR >= row || nextC < 0 || nextC >= column) {
                        continue;
                    }
                    if (board[nextR][nextC] == 1 || board[nextR][nextC] == 2) {
                        liveCount++;
                    }
                }

                if (board[r][c] == 1) {
                    if (liveCount != 2 && liveCount != 3) {
                        board[r][c] = 2;
                    }
                } else {
                    if (liveCount == 3) {
                        board[r][c] = 3;
                    }
                }
            }
        }

        for (int r = 0; r<row; r++) {
            for (int c = 0; c<column; c++) {
                if (board[r][c] == 2) {
                    board[r][c] = 0;
                } else if (board[r][c] == 3) {
                    board[r][c] = 1;
                }
            }
        }
    }

}
