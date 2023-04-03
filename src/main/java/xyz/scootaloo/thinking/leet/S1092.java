package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/28
 */
public class S1092 {

    @SuppressWarnings("all") // 不检查重复内容
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        //         3
        //         2
        //         1
        // 4 3 2 1 0

        for (int i = 0; i <= str1.length(); i++) {
            dp[i][str2.length()] = str1.length() - i;
        }
        for (int j = 0; j <= str2.length(); j++) {
            dp[str1.length()][j] = str2.length() - j;
        }
        // 0 j j j j j
        // i 0
        // i
        // i

        // dp[i][j] = 包含str1[i-]和str2[j-]的最短序列
        for (int i = str1.length() - 1; i >= 0; --i) {
            for (int j = str2.length() - 1; j >= 0; --j) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    // 如果str1[i]==str2[j], 那么再拼接一个str1[i]就可以得到最短超序列
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    // 不相等，取min(str1[i-1]到str2[j], str1[i]到str2[j-1])+1的举例
                    // 其中+1表示加上当前字符
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                builder.append(str1.charAt(i));
                i++;
                j++;
            } else if (dp[i][j] - 1 == dp[i + 1][j]) {
                builder.append(str1.charAt(i));
                i++;
            } else if (dp[i][j] - 1 == dp[i][j + 1]) {
                builder.append(str2.charAt(j));
                j++;
            }
        }

        if (i < str1.length()) {
            builder.append(str1.substring(i));
        } else if (j < str2.length()) {
            builder.append(str2.substring(j));
        }

        return builder.toString();
    }

}
