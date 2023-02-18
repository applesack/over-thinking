package xyz.scootaloo.thinking.draft.onlinetesting.yuewen;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/01 - 19:36
 */
public class Solution2 {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // write code here
        if (n >= 0) System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(
                solution2.merge(new int[] { 1, 2, 3, 0, 0, 0 },
                        3, new int[] { 2, 5, 6 }, 3))
        );
    }

}
