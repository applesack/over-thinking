package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/11 - 8:21
 */
public class S1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        int[] cache = new int[26];
        int len = s1.length(), pos;
        for (int i = 0; i < len; i++) {
            pos = s1.charAt(i) - 'a';
            cache[pos]++;
        }
        for (int i = 0; i < len; i++) {
            pos = s2.charAt(i) - 'a';
            cache[pos]--;
            if (cache[pos] < 0) {
                return false;
            }
        }

        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2) {
                    break;
                }
            }
        }

        return diff == 0 || diff == 2;
    }

}
