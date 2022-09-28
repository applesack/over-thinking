package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/27 - 11:59
 */
public class SInterview0102 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] countMap = new int['z' - 'A' + 1];
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            countMap[ch - 'A']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            countMap[ch - 'A']--;
        }

        for (int count : countMap) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

}
