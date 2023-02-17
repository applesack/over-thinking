package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/14 - 18:01
 */
public class S805 {

    private static final int[] sum = new int[2];
    private static final ArrayList<ArrayList<Integer>> store = new ArrayList<>();

    static {
        store.add(new ArrayList<>());
        store.add(new ArrayList<>());
    }

    public boolean splitArraySameAverage(int[] nums) {
        clear();
        return dfs(nums, 0);
    }

    private void clear() {
        sum[0] = 0;
        sum[1] = 0;
        store.get(0).clear();
        store.get(1).clear();
    }

    private boolean dfs(int[] nums, int pos) {
        if (pos == nums.length) {
            if (store.get(0).isEmpty() || store.get(1).isEmpty()) {
                return false;
            }
            return resolve();
        }

        if (sum[0] == sum[1]) {
            store(nums[pos], 0);
            return dfs(nums, pos + 1);
        }

        store(nums[pos], 0);
        if (dfs(nums, pos + 1)) {
            return true;
        }
        remove(0);

        store(nums[pos], 1);
        if (dfs(nums, pos + 1)) {
            return true;
        }
        remove(1);

        return false;
    }

    private void store(int num, int idx) {
        store.get(idx).add(num);
        sum[idx] += num;
    }

    private void remove(int idx) {
        int value = store.get(idx).remove(store.get(idx).size() - 1);
        sum[idx] -= value;
    }

    private boolean resolve() {
        double l = (double) sum[0] / store.get(0).size();
        double r = (double) sum[1] / store.get(1).size();
        return l == r;
    }

}
