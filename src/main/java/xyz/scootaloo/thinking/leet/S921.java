package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/04 - 18:02
 */
public class S921 {

    public int minAddToMakeValid(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int count = 0;
        int ans = 0;

        for (int i = 0; i<s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ++count;
            } else {
                if (count == 0) {
                    ++ans;
                } else {
                    --count;
                }
            }
        }

        return count + ans;
    }

}
