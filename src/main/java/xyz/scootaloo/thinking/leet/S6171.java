package xyz.scootaloo.thinking.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/03 - 22:32
 */
public class S6171 {

    public boolean findSubarrays(int[] nums) {
        Set<Integer> sum = new HashSet<>();
        for (int i = 1; i<nums.length; i++) {
            int local = nums[i] + nums[i - 1];
            if (sum.contains(local)) {
                return true;
            }
            sum.add(local);
        }
        return false;
    }

}
