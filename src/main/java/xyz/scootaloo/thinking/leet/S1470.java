package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/29 - 8:44
 */
public class S1470 {

    public int[] shuffle(int[] nums, int n) {
        final int[] result = new int[nums.length];
        for (int i = 0; i < n; i++) {
            result[i << 1] = nums[i];
            result[(i << 1) + 1] = nums[n + i];
        }
        return result;
    }

}
