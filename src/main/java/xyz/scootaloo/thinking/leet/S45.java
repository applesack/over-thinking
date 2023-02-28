package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/28
 */
public class S45 {

    public int jump(int[] nums) {
        int len = nums.length;
        int[] step = new int[len];
        for (int i = 0; i < len; i++) {
            step[i] = Integer.MAX_VALUE;
        }

        step[0] = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] - 1) {
                continue;
            }
            for (int j = i + 1; j < len && j <= (i + nums[i]); j++) {
                step[j] = Math.min(step[j], step[i] + 1);
            }
        }

        return step[len - 1];
    }

}
