package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/06
 */
public class S387 {

    public int firstUniqChar(String s) {
        int[] records = new int[26];
        for (int i = 0; i<26; i++) {
            records[i] = -1;
        }
        for (int i = 0; i<s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (records[pos] == -1) {
                records[pos] = i;
            } else {
                records[pos] = -2;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i<26; i++) {
            if (records[i] >= 0 && records[i] < ans) {
                ans = records[i];
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

}
