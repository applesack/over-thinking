package xyz.scootaloo.thinking.leet;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/02/14
 */
public class S1124 {

    /**
     * <a href="https://leetcode.cn/problems/longest-well-performing-interval/solutions/2110587/shu-ju-jie-gou-he-suan-fa-qian-zhui-he-b-2cvz/">...</a>
     * <a href="https://leetcode.cn/problems/longest-well-performing-interval/solutions/2110475/python3javacgo-yi-ti-yi-jie-qian-zhui-he-0os2/">...</a>
     */
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i<hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                // [0, i]这个区间内的数字, 大于8的数超过一半
                ans = i + 1;
            } else if (map.containsKey(sum - 1)) {
                // (sum - 1) 一个数任意次加一或者减一操作后, 如果得到的数为正数, 那么说明这组任意次操作中, 加操作多于减操作
                ans = Math.max(ans, i - map.get(sum - 1)); // 获取这段序列的长度
            }
            map.putIfAbsent(sum, i);
        }
        return ans;
    }

}
