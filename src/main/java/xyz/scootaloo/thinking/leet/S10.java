package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S10 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for (int i = 0; i <= m; i++) { // 搜索s, s[i-1]代表当前字符
            for (int j = 1; j <= n; j++) { // 搜索p, p[j-1]代表当前模式
                if (p.charAt(j - 1) == '*') { // 当前模式是*
                    // 默认情况下, *模式可以跳过上一个字符(即匹配长度为0的字符), 取上上个字符的结果
                    // 即 ab* 匹配 a
                    f[i][j] = f[i][j - 2];
                    if (match(s, p, i, j - 1)) {
                        // 如果当前字符与上一个模式匹配, 那么有两种选择
                        // 取上一个模式匹配的结果, 或者跳过上一个模式其上上个模式的匹配结果
                        // 这里f[i][j]已经重置成f[i][j-2]了
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    // 其他字符
                    if (match(s, p, i, j)) {
                        // 如果上一个模式匹配不成功, 那么当前模式即使匹配成功也不行
                        // a. 不能匹配 bc
                        // a*b 不能匹配 acb
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }

        return f[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            // 如果一个模式为*, 那么它在跳过前一个字符时, 取上上个字符的匹配结果时
            // 即 a* 不能匹配 b
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            // '.'匹配任何字符
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
