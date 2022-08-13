package xyz.scootaloo.thinking.leet;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/8/13 上午9:15
 */
public class S768 {

    public int maxChunksToSorted(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        int sum = 0;
        int total = 0;

        int ans = 0;

        for (int idx = 0; idx < arr.length; ++idx) {
            sum += arr[idx];
            total += sorted[idx];
            if (sum == total) {
                ans++;
            }
        }

        return ans;
    }

}
