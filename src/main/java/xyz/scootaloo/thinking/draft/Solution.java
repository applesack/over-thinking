package xyz.scootaloo.thinking.draft;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/22 - 19:38
 */
public class Solution {

    private final Random random = new Random();

    /**
     * <h2>积分抽奖</h2>
     *
     * @param integrals 使用数组描述的积分列表, 数组下标为用户id
     * @return 返回中奖的用户id
     */
    public int lottery(int[] integrals) {
        if (integrals == null || integrals.length == 0) {
            throw new IllegalArgumentException("非法输入: 空数组");
        }

        if (integrals.length == 1) {
            // 假如只有一个用户参与抽奖, 那么这个用户必定中奖
            return 0;
        }

        // 算法说明:
        // 举一个例子, 假设输入为 [1, 2, 5]
        // 根据权重, user[0]的中奖概率为 1/8, user[1]的概率为 2/8, user[2]的概率为 5/8

        // 为了模拟这个概率, 可以把用户的积分数组看成是一个区间, 即
        // user[0]的区间为 [0, 1)
        // user[1]的区间为 [1, 3)
        // user[2]的区间为 [3, 8)
        // 接下来生成一个 0~8 的随机数, 这个随机数命中的区间的概率, 正好就是用户的积分和积分总数的比

        /* 计算积分总数 */
        int sum = 0;
        for (int integral : integrals) {
            sum += integral;
        }

        /* 用数组模拟区间 */
        int[][] intervals = buildIntervals(integrals);
        int randomValue = random.nextInt(sum);

        /* 检查区间命中情况 */
        for (int i = integrals.length - 1; i >= 0; i--) {
            if (randomValue >= intervals[i][0]) {
                return intervals[i][1];
            }
        }

        // 假如以上代码正常工作, 则不会运行到这个语句
        return integrals[0];
    }

    private int[][] buildIntervals(int[] integrals) {
        // 二维数组, 第一个元素是区间的偏移量, 第二个元素是用户id
        int[][] intervals = new int[integrals.length][2];
        int offset = 0;
        for (int i = 0; i < integrals.length; i++) {
            intervals[i] = new int[] { offset, i };
            offset += integrals[i];
        }
        // 根据区间数组的第一个元素, 偏移量, 进行升序排序 (由小到大)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        return intervals;
    }

}
