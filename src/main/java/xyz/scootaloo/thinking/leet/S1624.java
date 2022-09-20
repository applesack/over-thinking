package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/17 - 9:41
 */
public class S1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] latest = new int[26];
        for (int i = 0; i < 26; i++) {
            latest[i] = -1;
        }

        int max = -1, ch, gap;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - 'a';
            if (latest[ch] != -1) {
                gap = i - latest[ch] - 1;
                if (gap > max) {
                    max = gap;
                }
            } else {
                latest[ch] = i;
            }
        }

        return max;
    }

}
