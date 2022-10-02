package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/02 - 11:39
 */
public class S6195 {

    public int deleteString(String s) {
        return dfs(s, 0);
    }

    private int dfs(String s, int pos) {
        int mid = s.length() / 2;
        int act1 = 1, act2 = 1;
        for (int i = pos + 1; i<=mid; i++) {
            boolean valid = true;
            int side = pos - i + 1;
            for (int j = 0; j<side; j++) {
                if (s.charAt(j) != s.charAt(side + j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                act1 = Math.max(act1, dfs(s, i));
            }
        }
        return Math.max(act1, act2);
    }

}
