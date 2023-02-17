package xyz.scootaloo.thinking.leet;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/08 - 9:27
 */
public class S870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        Integer[] indies = new Integer[len];
        for (int i = 0; i < len; i++) {
            indies[i] = i;
        }

        Arrays.sort(indies, Comparator.comparingInt(i -> nums2[i]));
        Arrays.sort(nums1);
        int l = 0, r = len - 1;
        for (int num : nums1) {
            if (num > nums2[indies[l]]) {
                nums2[indies[l++]] = num;
            } else {
                nums2[indies[r--]] = num;
            }
        }

        return nums2;
    }

}
