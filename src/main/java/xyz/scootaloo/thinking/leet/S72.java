package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/08
 */
public class S72 {

    /*      0 1 2 3 4 5
              h o r s e
        0   0 1 2 3 4 5
        1 r 1 1 2 2 3 4
        2 o 2
        3 s 3
     */
    @SuppressWarnings("all")
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j],     // 删除a的一个字符
                            dp[i][j - 1],     // 删除b的一个字符
                            dp[i - 1][j - 1]  // 将a的一个字符修改为b
                    ) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    private int min(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

}
