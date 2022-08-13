package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/8/13 上午8:54
 */
public class S769 {

    public int maxChunksToSorted(int[] arr) {
        int total = 0;
        int sum = 0;
        int ans = 0;

        for (int idx = 0; idx<arr.length; idx++) {
            total += idx;
            sum += arr[idx];

            if (sum == total) {
                ans++;
                sum = 0;
                total = 0;
            }
        }
        return ans;
    }

}
