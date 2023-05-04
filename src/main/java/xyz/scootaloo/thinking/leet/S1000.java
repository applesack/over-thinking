package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/04/04
 */
public class S1000 {

    public int mergeStones(int[] stones, int k) {
        int len = stones.length;
        if ((len - 1) % (k - 1) > 0) {
            return -1;
        }

        var sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = stones[i] + sum[i];
        }

        var dp = new int[len][len];
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i; m < j; m += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += sum[j + 1] - sum[i];
                }
            }
        }
        return dp[0][len - 1];
    }

}
