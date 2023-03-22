package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/22
 */
public class S997 {

    private int[] parent;

    // 1, 3
    // 2, 3

    public int findJudge(int n, int[][] trust) {
        int[] ans = new int[n + 1];
        for (int[] t : trust) {
            ans[t[1]]++;
            ans[t[0]]--;
        }
        for (int i = 1; i<=n; i++) {
            if (ans[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

}
