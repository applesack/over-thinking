package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/20
 */
public class S713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0;
        int mul = 1, ans = 0;
        while (r < nums.length) {
            mul *= nums[r];
            while (mul >= k && l <= r) {
                mul /= nums[l++];
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }

}
