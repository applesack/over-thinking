package xyz.scootaloo.thinking.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/02/16
 */
public class S1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (map.containsKey(rest)) {
                return new int[] { map.get(rest), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

}
