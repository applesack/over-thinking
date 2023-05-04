package xyz.scootaloo.thinking.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/04/04
 */
public class S1000 {

    private       int                 k;
    private       int                 len;
    private       int[]               sum;
    private final Map<Group, Integer> costMap = new HashMap<>();

    public int mergeStones(int[] stones, int k) {
        this.k = k;
        len = stones.length;
        sum = new int[len];
        sum[0] = stones[0];
        for (int i = 1; i < len; ++i) {
            sum[i] = stones[i] + sum[i - 1];
        }
        return solve(0, len - 1, k);
    }

    private int solve(int l, int r, int count) {
        Group result = new Group(l, r, count);
        if (costMap.containsKey(result)) {
            return costMap.get(result);
        }

        int cost = Integer.MAX_VALUE;
        int distance = r - l + 1;
        if (distance == count) {
            cost = range(l, r);
        } else if (distance < count) {
            cost = -1;
        } else {
            // todo
        }
        costMap.put(result, cost);
        return cost;
    }

    private int range(int l, int r) {
        if (l == 0) {
            return sum[r];
        }
        return sum[r] - sum[l - 1];
    }

    record Group(int left, int right, int count) {
    }

}
