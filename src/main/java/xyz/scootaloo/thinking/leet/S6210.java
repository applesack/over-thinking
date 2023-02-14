package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/15 - 23:10
 */
public class S6210 {

    public int minimizeArrayValue(int[] nums) {
        int len = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        int max;
        while (true) {
            list.clear();
            max = 0;
            for (int i = 1; i < len; i++) {
                if (nums[i] == max) {
                    list.add(i);
                    continue;
                }
                if (nums[i] > max) {
                    max = nums[i];
                    list.clear();
                    list.add(i);
                }
            }

            int worth = list.get(0) - nums[list.get(0) - 1];
            int worthIdx = list.get(0);
            for (Integer idx : list) {
                if (nums[idx] - nums[idx - 1] == 0) {
                    return selectMax(nums);
                }
                if (nums[idx] < nums[idx - 1]) {
                    continue;
                }

                if (nums[idx] - nums[idx - 1] > worth) {
                    worth = nums[idx] - nums[idx - 1];
                    worthIdx = idx;
                }
            }

            if (nums[worthIdx] < nums[worthIdx - 1]) {
                return selectMax(nums);
            }

            nums[worthIdx]--;
            nums[worthIdx - 1]++;
        }
    }

    private int selectMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

}
