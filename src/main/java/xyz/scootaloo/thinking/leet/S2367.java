package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 16:51
 */
public class S2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        int limit = nums.length - 1;
        int left, right, current, pos;
        for (int i = 1; i < limit; i++) {
            current = nums[i];
            left = nums[i - 1];
            right = nums[i + 1];

            if (current - left != diff) {
                pos = i;
                while (pos > 0 && current - left < diff) {
                    left = nums[--pos];
                }
                if (current - left != diff) {
                    continue;
                }
            }

            if (right - current != diff) {
                pos = i;
                while (pos < limit && right - current < diff) {
                    right = nums[++pos];
                }
                if (right - current != diff) {
                    continue;
                }
            }

            ans++;
        }

        return ans;
    }

}
