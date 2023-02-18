package xyz.scootaloo.thinking.leet;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/02/06
 */
public class S451 {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        List<Map.Entry<Character, Integer>> local = map.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .toList();

        StringBuilder buff = new StringBuilder(s.length());
        for (Map.Entry<Character, Integer> entry : local) {
            repeat(buff, entry.getKey(), entry.getValue());
        }

        return buff.reverse().toString();
    }

    private void repeat(StringBuilder buff, char ch, int count) {
        buff.append(String.valueOf(ch).repeat(Math.max(0, count)));
    }

}
