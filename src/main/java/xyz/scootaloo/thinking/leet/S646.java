package xyz.scootaloo.thinking.leet;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/03 - 10:10
 */
public class S646 {

    /**
     * [1, 2], [2, 3], [3, 4]
     */
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int max = 1, tmp = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > tmp) {
                max++;
                tmp = pairs[i][1];
            }
        }

        return max;
    }

}
