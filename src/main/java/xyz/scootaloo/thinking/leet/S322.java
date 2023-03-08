package xyz.scootaloo.thinking.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/03/05
 */
public class S322 {

    private final Map<Integer, Integer> mem = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        mem.clear();
        Arrays.sort(coins);
        return dfs(coins, amount);
    }

    private int dfs(int[] coins, int amount) {
        if (mem.containsKey(amount)) {
            return mem.get(amount);
        }
        int minCount = amount == 0 ? 0 : Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) {
                break;
            }
            int local = dfs(coins, amount - coin);
            if (local == -1) {
                continue;
            }
            minCount = Math.min(minCount, local + 1);
        }
        if (minCount == Integer.MAX_VALUE || minCount == -1) {
            minCount = -1;
        }
        mem.putIfAbsent(amount, minCount);
        return minCount;
    }

}
