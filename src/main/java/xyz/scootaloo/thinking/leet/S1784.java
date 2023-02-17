package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/03 - 8:23
 */
public class S1784 {

    public boolean checkOnesSegment(String s) {
        if (s.length() <= 2) {
            return true;
        }

        int i = 0;
        while (i < s.length() && s.charAt(i) == '1') {
            ++i;
        }

        if (i > s.length()) {
            return true;
        }

        ++i;
        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                return false;
            }
            i++;
        }

        return true;
    }

}
