package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S300 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1, j;
        for (int i = 1; i<len; i++) {
            dp[i] = 1;
            int local = 0;
            for (j = i - 1; j>=0; j--) {
                if (nums[j] < nums[i] && dp[j] > local) {
                    local = dp[j];
                }
            }
            if (local == 0) {
                continue;
            }
            dp[i] += local;
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}
