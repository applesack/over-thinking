package xyz.scootaloo.thinking.leet;

import java.util.PriorityQueue;

/**
 * @author AppleSack
 * @since 2023/02/19
 */
public class S1792 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
        });
        for (int[] klass : classes) {
            heap.offer(klass);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] arr = heap.poll();
            if (arr == null) {
                continue;
            }
            arr[0] += 1;
            arr[1] += 1;
            heap.offer(arr);
        }

        double ans = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] arr = heap.poll();
            if (arr == null) {
                continue;
            }
            int pass = arr[0], total = arr[1];
            ans += 1.0 * pass / total;
        }

        return ans / classes.length;
    }

}
