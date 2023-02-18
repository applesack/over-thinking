package xyz.scootaloo.thinking.draft.onlinetesting;

import java.util.Scanner;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/29 - 19:30
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] version1 = parse(scanner.nextLine());
        int[] version2 = parse(scanner.nextLine());

        int limit = Math.min(version1.length, version2.length);
        for (int i = 0; i<limit; i++) {
            int v1 = version1[i];
            int v2 = version2[i];
            if (v1 != v2) {
                if (v1 > v2) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
                return;
            }
        }

        System.out.println(0);
    }

    private static int[] parse(String line) {
        String[] segments = line.split("\\.");
        int[] rsl = new int[segments.length];
        for (int i = 0; i<rsl.length; i++) {
            rsl[i] = Integer.parseInt(segments[i]);
        }
        return rsl;
    }

}
