package xyz.scootaloo.thinking.leet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author AppleSack
 * @since 2023/03/23
 */
public class S128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        boolean hasInit = false;
        int last = 0;
        int local = 0;
        int ans = 0;
        for (Integer num : set) {
            if (!hasInit) {
                hasInit = true;
                last = num;
                local = 1;
                ans = 1;
            } else {
                if (num - last == 1) {
                    local++;
                } else {
                    local = 1;
                }
                last = num;
                ans = Math.max(ans, local);
            }
        }
        return ans;
    }

}
