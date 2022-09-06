package xyz.scootaloo.thinking.leet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/06 - 11:48
 */
public class S907 {

    private static final long MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        final int len = arr.length;
        final int[] left = new int[len];
        final int[] right = new int[len];

        final Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = len;
            } else {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum = (sum + (long) (i - left[i]) * (right[i] - i) * arr[i] % MOD) % MOD;
        }

        return (int) sum;
    }

}
