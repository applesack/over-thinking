package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/10 - 11:55
 */
public class S801 {

    public int minSwap(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[][] dp = new int[len][2];
        dp[0][1] = 1;
        // dp[i][0] 如果当前位置不替换, 能得到的最优解;
        // dp[i][1] 如果当前位置替换, 能得到的最优解;

        for (int i = 1; i < len; i++) {
            int l1 = nums1[i - 1], r1 = nums1[i];
            int l2 = nums2[i - 1], r2 = nums2[i];

            // (   1   )   (  2   )  (   3  )   (   4   ) 保证num[i]能交换必须保证4个条件都能通过
            if (l1 < r1 && l1 < r2 && l2 < r1 && l2 < r2) {
                // num1[i] 和 num2[i] 无论是否交换, 都然能保持严格递增
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]); // 选取上一次(替换或不替换)的最小值
                dp[i][1] = dp[i][0] + 1; // 替换了也可以维持递增, 但是会让交换次数+1
            } else if (l1 < r1 && l2 < r2) {
                // 如果这里的条件成立, 代表(2)(3)当中有一个不成立, 即
                // 代表 num1[i - 1] 和 num1[i] 是严格递增, 但是替换后违反递增

                // 1 2 4   替换[2]后  1 2 5  num2没有严格递增 需要替换一次[1]  1 4 5
                // 1 4 5             1 4 4                                1 2 4

                dp[i][0] = dp[i - 1][0]; // 不替换也能维持结果正确性
                dp[i][1] = dp[i - 1][1] + 1; // 替换两次, 即上一次替换加上当前替换
            } else {
                // 条件 (2)(3) 都不成立, 必须执行替换保证严格递增

                dp[i][0] = dp[i - 1][1]; // 上一次替换, 这一次不替换
                dp[i][1] = dp[i - 1][0] + 1; // 上一次没替换, 这一次替换
            }
        }

        return Math.min(dp[len - 1][0], dp[len - 1][1]);
    }

}
