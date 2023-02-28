package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/28
 */
public class S55 {

    public boolean canJump(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pos < i) {
                return false;
            }
            if (nums[i] + i > pos) {
                pos = nums[i] + i;
            }
        }
        return true;
    }

}
