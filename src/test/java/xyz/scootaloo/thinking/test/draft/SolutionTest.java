package xyz.scootaloo.thinking.test.draft;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.draft.onlinetesting.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/22 - 21:38
 */
public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void test() {
        display(new int[] { 1, 2, 5 }, 200);
        display(new int[] { 1, 2, 5 }, 200);
        display(new int[] { 1, 2, 5 }, 200);

        display(new int[] { 20, 34, 160, 2 }, 300);
        display(new int[] { 20, 34, 160, 2 }, 300);
        display(new int[] { 20, 34, 160, 2 }, 300);
    }

    /**
     * @param input  输入
     * @param repeat 重复次数
     */
    private void display(int[] input, int repeat) {
        System.out.println("-------------------------");

        int sum = IntStream.of(input).sum();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int id = 0; id < input.length; id++) {
            // 记录用户id和它的预期中奖次数; 这里除法运算可能导致精确缺失, 但不影响直观效果
            countMap.put(id, input[id] * repeat / sum);
        }

        Map<Integer, Integer> winMap = new HashMap<>();
        for (int i = 0; i < repeat; i++) {
            int id = solution.lottery(input);
            if (winMap.containsKey(id)) {
                winMap.put(id, winMap.get(id) + 1);
            } else {
                winMap.put(id, 1);
            }
        }

        // 输出结果
        System.out.printf("输入: %s; 测试次数: %s\n", Arrays.toString(input), repeat);
        for (int id = 0; id < input.length; id++) {
            int winCount = 0;
            if (winMap.containsKey(id)) {
                winCount = winMap.get(id);
            }

            System.out.printf("用户id[%s], 预期中奖次数: %s, 实际中奖次数: %s%n", id, countMap.get(id), winCount);
        }

        System.out.println("\n".repeat(3));
    }

}
