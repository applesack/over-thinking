package xyz.scootaloo.thinking.leet;

import java.util.*;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/06 - 19:36
 */
public class S828 {

    public int uniqueLetterString(String s) {
        final Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new LinkedList<>());
                map.get(s.charAt(i)).add(-1);
            }
            map.get(s.charAt(i)).add(i);
        }

        int ans = 0;
        for (List<Integer> indies : map.values()) {
            indies.add(s.length());
            indies = new ArrayList<>(indies);
            for (int i = 1; i < indies.size() - 1; i++) {
                ans += (indies.get(i) - indies.get(i - 1)) * (indies.get(i + 1) - indies.get(i));
            }
        }

        return ans;
    }

}
