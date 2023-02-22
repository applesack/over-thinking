package xyz.scootaloo.thinking.leet;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/02/20
 */
public class S2347 {

    public String bestHand(int[] ranks, char[] suits) {
        // 检查是否有同花
        boolean isSameColor = true;
        for (int i = 1; i < 5; i++) {
            if (suits[i] != suits[i - 1]) {
                isSameColor = false;
                break;
            }
        }
        if (isSameColor) {
            return "Flush";
        }

        // 检查是否存在三条
        Arrays.sort(ranks);
        int maxCount = 1, cur = ranks[0], pos = 1, cnt = 1;
        while (pos < 5) {
            if (ranks[pos] == cur) {
                cnt++;
            } else {
                if (cnt > maxCount) {
                    maxCount = cnt;
                }
                cnt = 1;
                cur = ranks[pos];
            }
            pos++;
        }
        if (cnt > maxCount) {
            maxCount = cnt;
        }

        if (maxCount >= 3) {
            return "Three of a Kind";
        }

        // 检查是否存在对子
        if (maxCount == 2) {
            return "Pair";
        }

        return "High Card";
    }

}
