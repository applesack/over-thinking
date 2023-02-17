package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/18 - 8:38
 */
public class S902 {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] arr = parseNumber(n);
        int[] inputs = parseInput(digits);
        int sum = 0;
        if (arr.length > 1) {
            for (int i = 1; i <= arr.length - 1; i++) {
                sum += Math.pow(inputs.length, i);
            }
        }

        sum += solute(arr, inputs, 0);

        return sum;
    }

    // 456325
    // 4----- 3 * 9^5
    //  5---- 4 * 9^4
    //   6--- 5 * 9^3
    //    3-- 2 * 9^2
    //     2- 1 * 9^1
    //      5 4
    private int solute(int[] n, int[] digits, int pos) {
        int count = 0;
        for (int digit : digits) {
            if (digit <= n[pos]) {
                count++;
            } else {
                break;
            }
        }
        if (pos == n.length - 1) {
            return count;
        }
        if (count >= 1) {
            int rest = solute(n, digits, pos + 1);
            int base = ((int) (Math.pow(digits.length, count - 1))) * (count - 1);
            if (rest == 0) {
                return 0;
            }
            return base + rest;
        } else {
            return 0;
        }
    }

    private int[] parseInput(String[] input) {
        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = input[i].charAt(0) - '0';
        }
        return array;
    }

    private int[] parseNumber(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        while (n > 0) {
            int rest = n % 10;
            list.addFirst(rest);
            n /= 10;
        }
        int[] array = new int[list.size()];
        int pos = 0;
        for (Integer num : list) {
            array[pos++] = num;
        }
        return array;
    }

}
