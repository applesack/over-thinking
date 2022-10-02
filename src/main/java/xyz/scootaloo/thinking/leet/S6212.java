package xyz.scootaloo.thinking.leet;

import java.util.*;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/01 - 22:31
 */
public class S6212 {

    public boolean equalFrequency(String word) {
        char[] chars = word.toCharArray();
        int[] count = new int[26];
        for (char ch : chars) {
            count[ch - 'a']++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            map.put(i, count[i]);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int ch = entry.getKey();
            if (check(map, ch)) {
                return true;
            }
        }

        return false;
    }

    private boolean check(Map<Integer, Integer> map, int ignoreCase) {
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == ignoreCase) {
                if (entry.getValue() != 1) {
                    set.add(entry.getValue() - 1);
                }
                continue;
            }
            set.add(entry.getValue());
        }
        return set.size() == 1;
    }

}
