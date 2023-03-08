package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S413 {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            int step = nums[i] - nums[i - 1];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] == step) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

}
