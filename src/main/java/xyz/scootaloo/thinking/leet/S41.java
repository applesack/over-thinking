package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/23
 */
public class S41 {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] != i + 1) {
                while (nums[i] >= 1 && nums[i] <= nums.length) {
                    if (nums[i] == nums[nums[i] - 1]) {
                        break;
                    }
                    swap(nums, i, nums[i] - 1);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
