package xyz.scootaloo.thinking.draft.untitled;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author AppleSack
 * @since 2023/03/24
 */
public class Untitled1 {

    public static void main(String[] args) {
        try {
            Untitled1 s = new Untitled1();
            System.out.println(s.getCount("X2Y3XZ"));
            System.out.println(s.getCount("Z3X(XY)2"));
            System.out.println(s.getCount("Z4(Y2(XZ2)3)2X2"));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
    case1: X2Y3XZ =>  x3, y3 z1
    case2: Z3X(XY)2 =>  z3 x3 y2
    case3: Z4(Y2(XZ2)3)2X2 => y4, x8, z16
     */

    /**
     * 输入字符串中，如果一个数字n在一个字母之前c，代表c出现了n次；
     * 另外，如果数字前有括号，代表括号内的字母出现次数*n
     * <p>
     * Z4(Y2(XZ2)3)2X2
     * 解释:
     * step1: z4, (y2, (x1, z2)*3)*2, x2
     * step2: z4, (y2, x3, z6)*2, x2
     * step3: z4, y4, x6, z12, x2
     * step4: z16, x8, y4
     * <p>
     * 解法，读入一个字符，记录这个字符出现一次，读入一个数字，将前面记录的字符*数字
     */
    public String getCount(String input) {
        Map<Character, Integer> countMap = new TreeMap<>(
                parse(input, 0, input.length() - 1, new HashMap<>()));
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            builder.append(entry.getKey()).append(entry.getValue());
        }
        return builder.toString();
    }

    private Map<Character, Integer> parse(
            String input, int left, int right, Map<Character, Integer> result) {
        // case1: X
        // case2: X3
        // case3: XZ3
        // case4: X(X)3
        Map<Character, Integer> preResult = new HashMap<>();
        for (int i = left; i<=right; i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                // 解析数字, 考虑数字不止个位数的情况
                int base = ch - '0';
                int end = i + 1;
                while (end <= right && Character.isDigit(input.charAt(end))) {
                    base *= 10;
                    base += input.charAt(end) - '0';
                    end++;
                }
                i = end - 1;
                multiple(preResult, base);
                merge(result, preResult);
                preResult.clear();
            } else {
                merge(result, preResult);
                preResult.clear();
                if (Character.isLetter(ch)) {
                    preResult.put(ch, 1);
                    continue;
                }
                int end = i + 1;
                int close = 1;
                while (end <= right) {
                    if (input.charAt(end) == '(') {
                        close++;
                    } else if (input.charAt(end) == ')') {
                        close--;
                    }
                    if (close == 0) {
                        break;
                    }
                    end++;
                }
                parse(input, i + 1, end - 1, preResult);
                i = end;
            }
        }
        merge(result, preResult);
        return result;
    }

    private void multiple(Map<Character, Integer> map, int num) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            entry.setValue(entry.getValue() * num);
        }
    }

    private void merge(Map<Character, Integer> source, Map<Character, Integer> other) {
        for (Map.Entry<Character, Integer> entry : other.entrySet()) {
            Character key = entry.getKey();
            if (source.containsKey(key)) {
                source.put(key, source.get(key) + entry.getValue());
            } else {
                source.put(key, entry.getValue());
            }
        }
    }

}
