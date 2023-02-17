package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S153 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if ((nums[mid] >= nums[l]) && nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}
