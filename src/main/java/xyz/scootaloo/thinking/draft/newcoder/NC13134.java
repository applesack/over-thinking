package xyz.scootaloo.thinking.draft.newcoder;

import java.util.Scanner;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/01 - 11:13
 */
public class NC13134 {

    public static void main(String[] args) {
        int[] arr = read();
        int result = solve(arr);
        System.out.println(result);
    }

    private static int[] read() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    private static int solve(int[] arr) {
        int[] l = new int[arr.length];
        int[] r = new int[arr.length];

        l[0] = r[arr.length - 1] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                l[i] = l[i - 1] + 1;
            } else {
                l[i] = 1;
            }
        }

        if (l[arr.length - 1] == arr.length) {
            return arr.length;
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                r[i] = r[i + 1] + 1;
            } else {
                r[i] = 1;
            }
        }

        int max = 0;
        for (int i = 1; i < (arr.length - 1); i++) {
            if (l[i] == 1) {
                if (arr[i + 1] - arr[i - 1] > 1) {
                    max = Math.max(max, l[i - 1] + r[i + 1] + 1);
                }

                if (i > 1 && arr[i - 2] + 1 < arr[i]) {
                    max = Math.max(max, l[i - 2] + r[i] + 1);
                }
            }
        }

        return max;
    }

}
