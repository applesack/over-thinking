package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S33 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        int lVal, rVal, mVal;
        while (l <= r) {
            lVal = nums[l];
            rVal = nums[r];
            m = l + ((r - l) >> 1);
            mVal = nums[m];

            if (lVal == target) {
                return l;
            }
            if (rVal == target) {
                return r;
            }

            if (mVal == target) {
                return m;
            } else if (lVal < mVal && mVal > rVal) {
                if (mVal > target && lVal < target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (lVal > mVal && rVal > mVal) {
                if (target > mVal && target < rVal) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // lVal < mVal && mVal < rVal
                if (target > mVal) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

}
