package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/20
 */
public class S209 {

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0, sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum - nums[l] >= target && l <= r) {
                sum -= nums[l++];
            }
            if (sum >= target && (r - l + 1) < min) {
                min = r - l + 1;
            }
            r++;
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }

}
