package xyz.scootaloo.thinking.startagain.s1;

/**
 * @author applesack
 * @since 2022/12/23 - 15:57
 */
public class S1P35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int middle = l + ((r - l) / 2);
            if (nums[middle] > target) {
                r = middle - 1;
            } else if (nums[middle] < target) {
                l = middle + 1;
            } else {
                return middle;
            }
        }

        return r + 1;
    }

}
