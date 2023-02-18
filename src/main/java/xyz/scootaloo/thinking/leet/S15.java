package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
public class S15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(help(nums, i, j, k));
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }

    private List<Integer> help(int[] nums, int i, int j, int k) {
        List<Integer> list = new ArrayList<>(3);
        list.add(nums[i]);
        list.add(nums[j]);
        list.add(nums[k]);
        return list;
    }

}
