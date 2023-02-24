package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
public class S438 {

    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != pCount[i]) {
                diff += Math.abs(sCount[i] - pCount[i]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (diff == 0) {
            ans.add(0);
        }

        int pos;
        for (int i = 0; i < sLen - pLen; i++) {
            // sCount[s[i] - 'a']--
            pos = s.charAt(i) - 'a';
            if (sCount[pos] == pCount[pos]) {
                diff++;
            } else if (sCount[pos] < pCount[pos]) {
                diff++;
            } else {
                diff--;
            }
            sCount[pos]--;

            // pCount[s[i + pLen - 1]]++
            pos = s.charAt(i + pLen) - 'a';
            if (sCount[pos] == pCount[pos]) {
                diff++;
            } else if (sCount[pos] > pCount[pos]) {
                diff++;
            } else {
                diff--;
            }
            sCount[pos]++;

            if (diff == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

}
