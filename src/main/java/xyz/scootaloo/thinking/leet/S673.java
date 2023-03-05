package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S673 {

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] countDp = new int[len];
        int[] lenDp = new int[len];
        lenDp[0] = 1;
        countDp[0] = 1;
        int max = 1, j;
        for (int i = 1; i < len; i++) {
            lenDp[i] = 1;
            countDp[i] = 1;
            int localLen = 0;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && lenDp[j] > localLen) {
                    localLen = lenDp[j];
                }
            }
            if (localLen == 0) {
                continue;
            }
            int localCount = 0;
            for (j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lenDp[j] == localLen) {
                    localCount += countDp[j];
                }
            }
            lenDp[i] += localLen;
            countDp[i] = localCount;
            if (lenDp[i] > max) {
                max = lenDp[i];
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (lenDp[i] == max) {
                count += countDp[i];
            }
        }

        return count;
    }

}
