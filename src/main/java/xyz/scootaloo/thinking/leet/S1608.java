package xyz.scootaloo.thinking.leet;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/12 - 9:07
 */
public class S1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, temp;
        for (int i = 0, j = n - 1; i<j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        for (int i = 1; i<=n; i++) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }

        return -1;
    }

}
