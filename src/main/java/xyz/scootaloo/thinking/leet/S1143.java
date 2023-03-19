package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/06
 */
public class S1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int M = text2.length(); // i
        int N = text1.length(); // j
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            if (text2.charAt(i) == text1.charAt(0)) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < N; j++) {
            if (text1.charAt(j) == text2.charAt(0)) {
                dp[0][j] = 1;
            }
        }

        int maxI = 0, maxJ = 0;
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (text2.charAt(i) == text1.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] > dp[maxI][maxJ]) {
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        return dp[maxI][maxJ];
    }

}
