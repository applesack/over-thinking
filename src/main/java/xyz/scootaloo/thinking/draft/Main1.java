package xyz.scootaloo.thinking.draft;

import java.util.Scanner;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/29 - 19:14
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int[] upper = new int[26];
        for (int i = 0; i<line.length(); i++) {
            char ch = line.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                upper[ch - 'A']++;
            }
        }

        for (int i = 0; i<upper.length; i++) {
            System.out.println((char) ('A' + i) + ":" + upper[i]);
        }
    }

}
