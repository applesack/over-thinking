package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.utils.mark.Modify;

import java.util.*;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 16:51
 */
@Modify("2023/3/31")
public class S2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        Map<Integer, List<Integer>> indies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            put(indies, nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (!indies.containsKey(current - diff) || !indies.containsKey(current + diff)) {
                continue;
            }
            if (findValue(indies.get(current - diff), i, true) &&
                    findValue(indies.get(current + diff), i, false)) {
                ans++;
            }
        }
        return ans;
    }

    private void put(Map<Integer, List<Integer>> map, int num, int idx) {
        if (map.containsKey(num)) {
            map.get(num).add(idx);
        } else {
            List<Integer> container = new ArrayList<>();
            container.add(idx);
            map.put(num, container);
        }
    }

    private boolean findValue(List<Integer> values, int idx, boolean left) {
        for (Integer value : values) {
            if (left && value < idx) {
                return true;
            }
            if (!left && value > idx) {
                return true;
            }
        }
        return false;
    }

}
