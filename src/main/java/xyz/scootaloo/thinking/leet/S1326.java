package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/21
 */
public class S1326 {

    /**
     * 2  3  4  3  2  1
     * [3, 4, 1, 1, 0, 0]
     */
    public int minTaps(int n, int[] ranges) {
        List<int[]> sorted = sortedRanges(n, ranges);
        if (sorted.isEmpty()) {
            return -1;
        }
        return findMin(sorted, n);
    }

    private int findMin(List<int[]> ranges, int bound) {
        int[] cur = ranges.get(0);
        if (cur[0] != 0) {
            return -1;
        }
        int count = 1;
        int R = 0;
        for (int i = 1; i < ranges.size(); i++) {
            int[] next = ranges.get(i);
            if (next[0] >= cur[0] && next[1] <= cur[1]) {
                continue;
            }

            if (next[1] > cur[1]) {
                if (next[0] > cur[0] && next[0] > R) {
                    if (next[0] - cur[1] > 1) {
                        return -1;
                    }
                    R = cur[1];
                    count++;
                }
            }
            cur = next;
        }
        if (cur[1] < bound) {
            return -1;
        }
        return count;
    }

    private List<int[]> sortedRanges(int max, int[] ranges) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) {
                continue;
            }
            list.add(new int[] { Math.max(0, i - ranges[i]), Math.min(max, i + ranges[i]) });
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        return list;
    }

}
