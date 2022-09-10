package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/08 - 13:44
 */
public class S667 {

    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int skip = n - 1;
        int pos = 0, point = 1;
        if (k > 1) {
            ans[pos++] = point;
        } else {
            point = 0;
        }

        while (k > 1) {
            point += skip;
            ans[pos++] = point;
            if (skip > 0) {
                skip = -(skip - 1);
            } else {
                skip = -(skip + 1);
            }
            k--;
        }

        if (skip > 0) {
            for (; pos<n; pos++) {
                ans[pos] = ++point;
            }
        } else {
            for (; pos<n; pos++) {
                ans[pos] = --point;
            }
        }

        return ans;
    }

}
