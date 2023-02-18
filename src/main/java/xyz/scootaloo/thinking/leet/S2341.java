package xyz.scootaloo.thinking.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/02/16
 */
public class S2341 {

    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        int rest = 0;
        int pair = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int count = entry.getValue();
            pair += count >> 1;
            if (count % 2 != 0) {
                rest += 1;
            }
        }

        return new int[] { pair, rest };
    }

}
