package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/19
 */
public class S986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        int iLimit = firstList.length, jLimit = secondList.length;
        int[] iInterval, jInterval;
        List<int[]> ans = new ArrayList<>();
        while (i < iLimit && j < jLimit) {
            iInterval = firstList[i];
            jInterval = secondList[j];
            if (jInterval[0] <= iInterval[1] && jInterval[1] >= iInterval[0]) {
                // 确定两个区间内有重叠内容

                // case 1
                // i 0 1 2
                // j   1 2 3

                // case 2
                // i   1 2 3
                // j 0 1 2
                ans.add(help(Math.max(iInterval[0], jInterval[0]), Math.min(iInterval[1], jInterval[1])));
            }
            if (iInterval[1] == jInterval[1]) {
                i++;
                j++;
            } else if (iInterval[1] > jInterval[1]) {
                j++;
            } else {
                i++;
            }
        }
        return collect(ans);
    }

    private int[] help(int l, int r) {
        return new int[] { l, r };
    }

    private int[][] collect(List<int[]> list) {
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
