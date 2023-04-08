package xyz.scootaloo.thinking.leet;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/04/07
 */
public class S1033 {

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[] { a, b, c };
        Arrays.sort(arr);
        return new int[] { getMin(arr[0], arr[1], arr[2]), getMax(arr[0], arr[1], arr[2]) };
    }

    private int getMin(int a, int b, int c) {
        int d1 = b - a;
        int d2 = c - b;
        if (d1 == d2 && d1 == 1) {
            return 0;
        }
        if (d1 <= 2 || d2 <= 2) {
            // 1 3 5
            return 1;
        }
        return 2;
    }

    private int getMax(int a, int b, int c) {
        int d1 = b - a;
        int d2 = c - b;
        if (d1 == 1) {
            return d2 - 1;
        }
        return d1 - 1 + d2 - 1;
    }

}
