package xyz.scootaloo.thinking.draft.onlinetesting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/29 - 19:21
 */
public class Main2 {

    private static final long plus = Long.MIN_VALUE + 2;
    private static final long minis = Long.MIN_VALUE + 3;
    private static final long xor = Long.MIN_VALUE + 4;
    private static final long invalid = Long.MIN_VALUE + 5;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        List<String> symbols = read(line);
        List<Integer> plusAct = new ArrayList<>();
        List<Integer> minisAct = new ArrayList<>();
        List<Integer> xorAct = new ArrayList<>();

        long[] arr = new long[symbols.size()];
        for (int i = 0; i < arr.length; i++) {
            String syb = symbols.get(i);
            if (syb.length() == 1) {
                char ch = syb.charAt(0);
                if (!(ch >= '0' && ch <= '9')) {
                    if (ch == '+') {
                        plusAct.add(i);
                        arr[i] = plus;
                    } else if (ch == '-') {
                        minisAct.add(i);
                        arr[i] = minis;
                    } else {
                        xorAct.add(i);
                        arr[i] = xor;
                    }
                    continue;
                }
            }
            arr[i] = Integer.parseInt(syb);
        }

        for (int pos : xorAct) {
            int left = findLeft(arr, pos);
            int right = findRight(arr, pos);
            arr[pos] = arr[left] ^ arr[right];
            arr[left] = invalid;
            arr[right] = invalid;
        }

        for (int pos : plusAct) {
            int left = findLeft(arr, pos);
            int right = findRight(arr, pos);
            arr[pos] = (int) arr[left] + (int) arr[right];
            arr[left] = invalid;
            arr[right] = invalid;
        }

        for (int pos : minisAct) {
            int left = findLeft(arr, pos);
            int right = findRight(arr, pos);
            arr[pos] = (int) arr[left] - (int) arr[right];
            arr[left] = invalid;
            arr[right] = invalid;
        }

        for (long l : arr) {
            if (l > invalid) {
                System.out.println(l);
                break;
            }
        }
    }

    private static int findLeft(long[] arr, int pos) {
        for (int i = pos - 1; i >= 0; i--) {
            if (arr[i] > invalid) {
                return i;
            }
        }
        return 0;
    }

    private static int findRight(long[] arr, int pos) {
        for (int i = pos + 1; i < arr.length; i++) {
            if (arr[i] > invalid) {
                return i;
            }
        }
        return 0;
    }

    private static List<String> read(String line) {
        StringBuilder buff = new StringBuilder();
        LinkedList<String> rsl = new LinkedList<>();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '+' || ch == '-' || ch == '^') {
                rsl.add(buff.toString());
                buff.setLength(0);
                buff.append(ch);
            } else {
                if (buff.length() == 1) {
                    char syb = buff.charAt(0);
                    if (!(syb >= '0' && syb <= '9')) {
                        rsl.add(buff.toString());
                        buff.setLength(0);
                        buff.append(ch);
                        continue;
                    }
                }
                buff.append(ch);
            }
        }
        if (buff.length() != 0) {
            rsl.add(buff.toString());
        }
        return new ArrayList<>(rsl);
    }

}
