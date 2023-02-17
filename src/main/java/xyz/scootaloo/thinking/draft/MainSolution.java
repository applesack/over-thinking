package xyz.scootaloo.thinking.draft;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/10 - 10:30
 */
public class MainSolution {

    public List<String> stringSplit(String str) {
        // 字符串中包含的结果可能是不定长的, 所以这里用链表存储临时结果
        StringBuilder buff = new StringBuilder();
        LinkedList<String> result = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 如果当前遇到了 &&, 收集之前保存的结果, 并且让指针前进一位
            if (ch == '&' && i < (str.length() - 1) && str.charAt(i + 1) == '&') {
                if (!buff.isEmpty()) {
                    result.add(buff.toString());
                    buff.setLength(0);
                }
                i++;
            } else {
                buff.append(ch);
            }
        }

        // 收集剩余的内容
        if (!buff.isEmpty()) {
            result.add(buff.toString());
        }

        // 使用ArrayList对结果再次存储, 当客户端访问时可以加速索引访问效率
        return new ArrayList<>(result);
    }

    public String stringJoint(String joint, String... words) {
        if (words.length == 1) {
            return words[0];
        }
        StringBuilder buff = new StringBuilder();
        for (String word : words) {
            buff.append(word);
            buff.append(joint);
        }
        buff.setLength(buff.length() - joint.length());
        return buff.toString();
    }

    public int findPrimeNumber(int limit) {
        if (limit < 1) {
            throw new RuntimeException("非法输入");
        }
        if (limit < 3) {
            return limit;
        }

        boolean[] marks = new boolean[limit + 2];
        marks[1] = true;
        limit += 1;
        for (int i = 2; i <= limit; i++) {
            if (!marks[i]) {
                for (int base = 2; (i * base) <= limit; base++) {
                    marks[base * i] = true;
                }
            }
        }

        for (int i = limit - 1; i >= 1; i--) {
            if (!marks[i]) {
                return i;
            }
        }

        return 1;
    }

    public int findDuplicateNumber(int[] input) {
        // 由于输入限定在一定范围内, 而且只需要找出一个重复项, 那么可以尝试将数组进行排序
        // 如果能找到有两个相邻的元素值相同, 那么这个就是结果

        // 简单排序
        for (int i = 0; i < input.length; i++) {
            if (input[i] == i) {
                continue;
            }
            while (input[i] != i) {
                if (input[i] == input[input[i]]) {
                    return input[i];
                }
                int idx = input[i];
                int tmp = input[idx];
                input[idx] = input[i];
                input[i] = tmp;
            }
        }

        throw new RuntimeException("没有找到重复项");
    }

    public int findSurvivor(int n, int m) {
        // 暂时没有想到比较好的解法, 使用的链表模拟性能较差

        // 初始化
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.addLast(i);
        }

        while (list.size() > 1) {
            int size = list.size();
            int removed = (m % size);
            if (removed == 0) {
                list.removeLast();
            } else {
                list.remove(removed - 1);
            }
        }

        return list.getFirst();
    }

    public List<String> fullPermutation(char... chars) {
        boolean[] selected = new boolean[chars.length];
        ArrayDeque<Character> path = new ArrayDeque<>();
        ArrayDeque<String> result = new ArrayDeque<>();
        dfs(result, path, chars, selected);
        return new ArrayList<>(result);
    }

    private void dfs(
            ArrayDeque<String> result, ArrayDeque<Character> path,
            char[] chars, boolean[] selected
    ) {
        if (!path.isEmpty()) {
            result.addLast(collect(path));
        }

        for (int i = 0; i < chars.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                path.addLast(chars[i]);
                dfs(result, path, chars, selected);
                path.removeLast();
                selected[i] = false;
            }
        }
    }

    private String collect(ArrayDeque<Character> deque) {
        StringBuilder buff = new StringBuilder(deque.size());
        for (char ch : deque) {
            buff.append(ch);
        }
        return buff.toString();
    }

}
