package xyz.scootaloo.thinking.draft.p360;

import java.util.Scanner;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/22 - 14:33
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt(), column = scanner.nextInt();
        int[] dp = new int[column];
        for (int i = 0; i<row; i++) {
            for (int j = 0; j<column; j++) {
                dp[j] += scanner.nextInt();
            }
        }

        int max = dp[0];
        for (int i = 1; i<column; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max + 2);
    }

}
