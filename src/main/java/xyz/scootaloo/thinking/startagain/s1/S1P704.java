package xyz.scootaloo.thinking.startagain.s1;

/**
 * @author applesack
 * @since 2022/12/23 - 15:22
 */
public class S1P704 {

    /**
     * 0 1 2 3
     * 1 3 5 6
     *
     * @param nums 有序数组
     * @param target 目标值
     * @return 目标值的下标
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1, midPos, midVal;
        while (l <= r) {
            midPos = l + ((r - l) / 2);
            midVal = nums[midPos];
            if (midVal == target) {
                // found
                return midPos;
            } else if (midVal < target) {
                l = midPos + 1;
            } else {
                r = midPos - 1;
            }
        }

        // not found
        return -1;
    }

}
