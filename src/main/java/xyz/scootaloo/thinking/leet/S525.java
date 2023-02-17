package xyz.scootaloo.thinking.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/02/14
 */
public class S525 {

    public int findMaxLength(int[] nums) {
        // key: 从[0-j]这段距离的0和1的抵消, value: j
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (sum == 0) {
                ans = i + 1;
            } else if (map.containsKey(sum)) {
                // 找到一个位置, 设这个位置为 j, 从j开始, 任意操作后这个值仍然是sum, 说明这段操作0和1的数量相等
                // 找到这个位置, 和当前最大值进行比较
                ans = Math.max(ans, i - map.get(sum));
            }
            map.putIfAbsent(sum, i);
        }
        return ans;
    }

}
