package xyz.scootaloo.thinking.leet;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/20 - 7:47
 */
public class S698 {

    // 5, 4, 3, 3, 2, 2, 1
    // 9 12 15 17 19 20
    // 5
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1 && nums.length > 0) {
            return true;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int amount = sum / k;
        if (amount * k != sum) {
            return false;
        }

        Arrays.sort(nums);

        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }

        for (int num : nums) {
            if (num > amount) {
                return false;
            }
        }

        return backtrack(nums, 0, new int[k], k, amount);
    }

    private boolean backtrack(
            final int[] nums, final int index,
            final int[] bucket, final int k, final int target
    ) {
        if (index == nums.length) {
            return true;
        }

        for (int i = 0; i < k; i++) {
            if (bucket[i] + nums[index] > target) {
                continue;
            }

            if (i > 0 && bucket[i] == bucket[i - 1]) {
                continue;
            }

            bucket[i] += nums[index];

            if (backtrack(nums, index + 1, bucket, k, target)) {
                return true;
            }

            bucket[i] -= nums[index];
        }

        return false;
    }

}
