package xyz.scootaloo.thinking.leet;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/14 - 8:21
 */
public class S1619 {

    public double trimMean(int[] arr) {
        if (arr.length == 0) {
            return 0.0;
        }

        Arrays.sort(arr);
        double sum = 0.0;
        int limit = arr.length * 95 / 100;
        for (int i = arr.length * 5 / 100; i < limit; i++) {
            sum += arr[i];
        }

        return sum / ((float) arr.length * 90 / 100);
    }

}
