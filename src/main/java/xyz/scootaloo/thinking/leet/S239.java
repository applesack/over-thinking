package xyz.scootaloo.thinking.leet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author AppleSack
 * @since 2023/03/23
 */
public class S239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Integer> queue = new ArrayDeque<>(nums.length - k + 2);
        ArrayList<Integer> ans = new ArrayList<>(nums.length - k + 1);
        for (int i = 0; i < k; i++) {
            add(map, nums[i]);
            queue.add(nums[i]);
        }
        ans.add(max(map));
        for (int i = k; i < nums.length; i++) {
            queue.add(nums[i]);
            int old = queue.poll();
            add(map, nums[i]);
            del(map, old);
            ans.add(max(map));
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void add(TreeMap<Integer, Integer> map, int num) {
        map.merge(num, 1, Integer::sum);
    }

    private void del(TreeMap<Integer, Integer> map, int num) {
        Integer count = map.get(num);
        count--;
        if (count == 0) {
            map.remove(num);
        } else {
            map.put(num, count);
        }
    }

    private int max(TreeMap<Integer, Integer> map) {
        return map.lastEntry().getKey();
    }

}
