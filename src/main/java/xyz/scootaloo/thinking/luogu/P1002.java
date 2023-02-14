package xyz.scootaloo.thinking.luogu;

import java.util.Scanner;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/01 - 14:34
 */
public class P1002 {

    private static final int[][] pointers = {
            { 1, 2 },
            { -1, 2 },
            { 1, -2 },
            { -1, -2 },
            { 2, 1 },
            { -2, 1 },
            { 2, -1 },
            { -2, -1 }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt() + 1;
        int row = scanner.nextInt() + 1;
        int horseCol = scanner.nextInt();
        int horseRow = scanner.nextInt();

        boolean[][] badPoint = new boolean[row][column];
        badPoint[horseRow][horseCol] = true;

        for (int i = 0; i < 8; i++) {
            int tarR = horseRow + pointers[i][0];
            int tarC = horseCol + pointers[i][1];
            if (tarR >= 0 && tarR < row && tarC >= 0 && tarC < column) {
                badPoint[tarR][tarC] = true;
            }
        }

        int[][] matrix = new int[row][column];
        matrix[0][0] = 1;
        for (int r = 1; r < row; r++) {
            if (badPoint[r][0]) {
                break;
            }
            matrix[r][0] = 1;
        }

        for (int c = 1; c < column; c++) {
            if (badPoint[0][c]) {
                break;
            }
            matrix[0][c] = 1;
        }

        for (int r = 1; r < row; r++) {
            for (int c = 1; c < column; c++) {
                if (badPoint[r][c]) {
                    matrix[r][c] = 0;
                    continue;
                }
                matrix[r][c] = matrix[r - 1][c] + matrix[r][c - 1];
            }
        }

        int result = matrix[row - 1][column - 1];
        System.out.println(result);
    }

}
