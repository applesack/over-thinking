package xyz.scootaloo.thinking.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/03/23
 */
public class S454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int len = nums1.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                add(map1, nums1[i] + nums2[j]);
                add(map2, nums3[i] + nums4[j]);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> num1entry : map1.entrySet()) {
            int need = -num1entry.getKey();
            if (map2.containsKey(need)) {
                ans += num1entry.getValue() * map2.get(need);
            }
        }
        return ans;
    }

    private void add(Map<Integer, Integer> map, int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

}
