package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/27
 */
public class S1638 {

    public int countSubstrings(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int ans = 0;
        for (int si = 0; si < sLen; si++) {
            for (int ti = 0; ti < tLen; ti++) {
                int diff = 0, d = 0;
                while (si + d < sLen && ti + d < tLen && diff < 2) {
                    if (s.charAt(si + d) != t.charAt(ti + d)) {
                        diff++;
                    }
                    if (diff == 1) {
                        ans++;
                    }
                    d++;
                }
            }
        }
        return ans;
    }

}
