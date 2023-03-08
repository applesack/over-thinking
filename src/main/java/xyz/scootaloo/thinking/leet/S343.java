package xyz.scootaloo.thinking.leet;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S343 {

    public int integerBreak(int n) {
        if (n <= 3) {
            return n == 2 ? 1 : 2;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], (i - j) * dp[j]);
            }
        }
        return dp[n];
    }

}
