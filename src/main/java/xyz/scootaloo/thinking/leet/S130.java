package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/24
 */
public class S130 {

    public void solve(char[][] board) {
        int R = board.length;
        int C = board[0].length;
        for (int r = 0; r < R; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0, 'V', 'O');
            }
            if (board[r][C - 1] == 'O') {
                dfs(board, r, C - 1, 'V', 'O');
            }
        }

        for (int c = 0; c < C; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c, 'V', 'O');
            }
            if (board[R - 1][c] == 'O') {
                dfs(board, R - 1, c, 'V', 'O');
            }
        }

        for (int r = 1; r < (R - 1); r++) {
            for (int c = 1; c < (C - 1); c++) {
                if (board[r][c] == 'O') {
                    dfs(board, r, c, 'X', 'O');
                }
            }
        }

        for (int r = 0; r<R; r++) {
            for (int c = 0; c<C; c++) {
                if (board[r][c] == 'V') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private final int[][] directions = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };

    private void dfs(char[][] board, int r, int c, char cover, char match) {
        int ROW = board.length;
        int COLUMN = board[0].length;

        board[r][c] = cover;
        for (int[] d : directions) {
            int newR = r + d[0];
            int newC = c + d[1];
            if (newC < 0 || newC >= COLUMN || newR < 0 || newR >= ROW || board[newR][newC] != match) {
                continue;
            }
            dfs(board, newR, newC, cover, match);
        }
    }

}
