package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/07 - 8:33
 */
public class S1800 {

    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int prev = nums[0];
        for (int i = 1; i<nums.length; i++) {
            if (nums[i] > prev) {
                prev = nums[i];
                nums[i] += nums[i - 1];
                if (nums[i] > max) {
                    max = nums[i];
                }
            } else {
                prev = nums[i];
            }
        }
        return max;
    }

}
