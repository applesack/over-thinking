package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S162 {

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid != nums.length - 1 && nums[mid] < nums[mid + 1]) {
                // 向右存在峰值
                l = mid + 1;
            } else {
                // 向左存在峰值
                r = mid - 1;
            }
        }
        return -1;
    }

}
