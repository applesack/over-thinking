package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/09 - 10:02
 */
public class S856 {

    public int scoreOfParentheses(String s) {
        return getScore(s, 0, s.length() - 1);
    }

    private int getScore(String s, int start, int end) {
        int pos = start;
        if (end - pos == 1) {
            return 1;
        }

        int l = 0;
        for (; pos<=end; pos++) {
            if (s.charAt(pos) == '(') {
                l++;
            } else {
                l--;
                if (l == 0) {
                    break;
                }
            }
        }

        if (pos < end) {
            return getScore(s, start, pos) + getScore(s, pos + 1, end);
        } else {
            return getScore(s, start + 1, end - 1) * 2;
        }
    }

}
