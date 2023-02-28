package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/28
 */
public class S213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length - 1];
        return Math.max(rob(nums, dp, 0, nums.length - 2),
                rob(nums, dp, 1, nums.length - 1));
    }

    private int rob(int[] nums, int[] dp, int start, int end) {
        dp[0] = nums[start];
        dp[1] = nums[start + 1];
        if (dp[0] > dp[1]) {
            dp[1] = dp[0];
        }
        for (int i = start + 2; i <= end; i++) {
            dp[i - start] = Math.max(dp[i - start - 1], dp[i - start - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }

}
