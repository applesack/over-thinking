package xyz.scootaloo.thinking.draft.onlinetesting.didi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/15 - 19:08
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++) {
            int next = scanner.nextInt();
            if (map.containsKey(next)) {
                map.put(next, map.get(next) + 1);
            } else {
                map.put(next, 1);
            }
        }

        int[] array = new int[map.size()];
        int pos = 0;
        for (Integer key : map.keySet()) {
            array[pos++] = key;
        }

        Arrays.sort(array);
        int maxL = 0, maxR = 0, maxValue = map.get(array[0]), value = maxValue;
        int l = 0;
        for (int r = 1; r<array.length; r++) {
            while (array[r] - array[l] > k) {
                value -= map.get(array[l]);
                l++;
            }
            value += map.get(array[r]);
            if (value > maxValue) {
                maxL = l;
                maxR = r;
            }
        }

        int sum = 0;
        for (int i = maxL; i<=maxR; i++) {
            sum += map.get(array[i]);
        }
        System.out.println(sum);
    }

}
