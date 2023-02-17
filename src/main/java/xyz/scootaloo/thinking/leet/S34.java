package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S34 {

    private final boolean LEFT  = true;
    private final boolean RIGHT = false;

    public int[] searchRange(int[] nums, int target) {
        int lBorder = searchBorder(nums, 0, nums.length - 1, target, LEFT);
        if (lBorder == -1) {
            return new int[] { -1, -1 };
        }
        return new int[] { lBorder, searchBorder(nums, lBorder, nums.length - 1, target, RIGHT) };
    }

    private int searchBorder(int[] nums, int l, int r, int target, boolean direction) {
        int ans = -1, mid, current;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            current = nums[mid];
            if (current == target) {
                ans = mid;
                if (direction == LEFT) {
                    r = mid - 1;
                } else if (direction == RIGHT) {
                    l = mid + 1;
                }
            } else if (current > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
