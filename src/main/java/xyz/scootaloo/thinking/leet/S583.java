package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/08
 */
public class S583 {

    //       s e a
    //     0 1 2 3
    //   0 0 1 2 3
    // e 1 1 2 1 2
    // a 2 2 3 2 1
    // t 3 3 4 3 2

    /*
             e t c o
           0 1 2 3 4
         0 0 1 2 3 4
       l 1 1.2.3.4.5
       e 2 1.1.2.3.4
       e 3 1.1.2.3.4
       t 4 1.2.1.2.3
       c 5 1.2.2.1.2
       o 6 1.2.
       d 7 1
       e 8 1
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
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
