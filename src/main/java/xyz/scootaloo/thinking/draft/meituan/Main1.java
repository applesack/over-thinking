package xyz.scootaloo.thinking.draft.meituan;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 给出一个长度为n的字符串，仅由小写字母组成。
 * <p>
 * 每一种小写字母都有一个权值wi。一个子序列的权值定义为这个子序列内所有字母的权值的乘积。子序列定义为原字符串删除若干个（包括0个）字母得到的字符串。
 * <p>
 * 你的问题是：设原字符串中权值最大的子序列的权值为w，对于所有权值等于w的子序列中，长度最长的子序列是哪一个？本题只需要输出该长度即可。
 *
 * @author flutterdash@qq.com
 * @since 2022/10/08 - 9:43
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupCount = scanner.nextInt();
        List<Pair> inputs = new LinkedList<>();
        for (int c = 0; c < groupCount; c++) {
            int[] weight = new int[26];
            for (int i = 0; i < 26; i++) {
                weight[i] = scanner.nextInt();
            }
            Pair pair = new Pair();
            pair.weight = weight;
            pair.line = scanner.next();
            inputs.add(pair);
        }


        for (Pair pair : inputs) {
            System.out.println(solute(pair.line, pair.weight));
        }
    }

    private static int solute(String line, int[] weight) {
        if (line.isEmpty()) {
            return 0;
        }

        int[] dp = new int[line.length()];
        int maxValue = 0;
        int maxLen = 0;
        dp[0] = weight[line.charAt(0) - 'a'];

        // 2 -10 3 -10
        // 2 3 -10 -10
        // 2 6   6
        int currentLen = 1;
        for (int i = 1; i < dp.length; i++) {
            int current = weight[line.charAt(i) - 'a'];
            int max = Math.max(current, current * dp[i - 1]);
            dp[i] = max;
            if (max == current) {
                currentLen = 1;
            } else {
                currentLen++;
            }

            if (max >= maxValue) {
                if (max > maxValue) {
                    maxValue = max;
                    maxLen = currentLen;
                } else {
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                    }
                }
            }
        }

        return maxLen;
    }

    private static class Pair {
        String line;
        int[] weight;
    }

}
