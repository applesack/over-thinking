package xyz.scootaloo.thinking.leet;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/02 - 10:48
 */
public class S6194 {

    public int minimizeXor(int num1, int num2) {
        int count = getOneCount(num2);
        boolean[] signs = fill(toBooleanArray(num1), num2);
        boolean[] ans = new boolean[signs.length];

        int bound = 0;
        for (int i = 0; i < signs.length; i++) {
            if (signs[i]) {
                bound = i;
                break;
            }
        }

        for (int i = bound; i < signs.length; i++) {
            if (count == 0) {
                break;
            }
            if (signs[i]) {
                ans[i] = true;
                count--;
            }
        }

        if (count > 0) {
            for (int i = ans.length - 1; i >= 0; i--) {
                if (!ans[i]) {
                    count--;
                    ans[i] = true;
                }
                if (count == 0) {
                    break;
                }
            }
        }
        return toNumber(ans);
    }

    private boolean[] fill(boolean[] array, int number) {
        boolean[] other = toBooleanArray(number);
        if (other.length <= array.length) {
            return array;
        }
        Arrays.fill(other, false);
        int diff = other.length - array.length;
        if (other.length - diff >= 0)
            System.arraycopy(array, 0, other, diff, other.length - diff);
        return other;
    }

    private int getOneCount(int num) {
        final int base = 1;
        int count = 0;
        while (num > 0) {
            if ((base & num) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    private boolean[] toBooleanArray(int num) {
        final int base = 1;
        StringBuilder buff = new StringBuilder();
        while (num > 0) {
            if ((base & num) == 1) {
                buff.insert(0, 1);
            } else {
                buff.insert(0, 0);
            }
            num = num >> 1;
        }
        boolean[] booleans = new boolean[buff.length()];
        for (int i = 0; i < buff.length(); i++) {
            booleans[i] = buff.charAt(i) == '1';
        }
        return booleans;
    }

    private int toNumber(boolean[] array) {
        int number = 0, len = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (!array[i]) {
                continue;
            }
            number += 1 << (len - i);
        }
        return number;
    }

}
