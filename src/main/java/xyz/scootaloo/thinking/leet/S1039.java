package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/04/02
 */
public class S1039 {

    public int minScoreTriangulation(int[] values) {
        // link https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/description/
        // 算法描述:
        // 计算多边形的顶点values最小值，及从顶点i到j划分成的三角形的最小值(其中i=0, j=len(values)-1)
        // 在i到j之间存在一个点k, i < k < j, 并且[i,j,k]可以组成一个三角形,
        // 那么这个三角形的左边的部分和右边的部分分别可以作为一个子问题进行进一步细分
        // 边界: 当i到j的距离不足3, 那么从i到j之间不能构造出三角形, 此时值为0
        int len = values.length;
        int[][] dp = new int[len][len];
        for (int i = len - 3; i >= 0; --i) {
            for (int j = i + 2; j < len; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + (values[i] * values[j] * values[k]));
                }
            }
        }
        return dp[0][len - 1];
    }

}
