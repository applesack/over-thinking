package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.utils.mark.Mark;

import java.util.*;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
@Mark("todo")
public class S30 {

    public List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length();
        int wLen = words[0].length();
        int width = words.length * wLen;
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> wCountMap = new HashMap<>();
        for (String value : words) {
            wCountMap.put(value, wCountMap.getOrDefault(value, 0) + 1);
        }

        for (int i = 0; i < wLen; i++) {
            Map<String, Integer> sCountMap = new HashMap<>();
            if (i + width > sLen) {
                break;
            }
            for (int j = i; j + wLen <= sLen && j + wLen <= i + width; j += wLen) {
                String word = s.substring(j, j + wLen);
                sCountMap.put(word, sCountMap.getOrDefault(word, 0) + 1);
            }

            int diff = getDiff(wCountMap, sCountMap);

            if (diff == 0) {
                ans.add(i);
            }

            int sCount, wCount;
            for (int j = i; j <= sLen - width - wLen; j += wLen) {
                // sCountMap[s[j, j+wLen]]--
                String word = s.substring(j, j + wLen);
                sCount = sCountMap.getOrDefault(word, 0);
                wCount = wCountMap.getOrDefault(word, 0);
                if (sCount > wCount) {
                    diff--;
                } else {
                    diff++;
                }
                if (sCount > 1) {
                    sCountMap.put(word, sCount - 1);
                } else {
                    sCountMap.remove(word);
                }

                // sCount[s[j + width, j + width + wLen]]++
                word = s.substring(j + width, j + width + wLen);
                sCount = sCountMap.getOrDefault(word, 0);
                wCount = wCountMap.getOrDefault(word, 0);
                if (sCount < wCount) {
                    diff--;
                } else {
                    diff++;
                }
                sCountMap.put(word, sCount + 1);

                if (diff == 0) {
                    ans.add(j + wLen);
                }
            }
        }

        return ans;
    }

    private int getDiff(Map<String, Integer> a, Map<String, Integer> b) {
        int diff = 0;
        Set<String> names = new HashSet<>();
        names.addAll(a.keySet());
        names.addAll(b.keySet());
        int aCount, bCount;
        for (String name : names) {
            aCount = a.getOrDefault(name, 0);
            bCount = b.getOrDefault(name, 0);
            if (aCount != bCount) {
                diff += Math.abs(aCount - bCount);
            }
        }
        return diff;
    }

}
