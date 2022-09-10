package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/08 - 10:00
 */
public class S526 {

    public int countArrangement(int n) {
        return dfs(n, 1, new boolean[n + 1]);
    }

    private int dfs(int n, int number, boolean[] visited) {
        if (number > n) {
            return 1;
        }

        int ans = 0;
        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (num % number == 0 || number % num == 0)) {
                visited[num] = true;
                ans += dfs(n, number + 1, visited);
                visited[num] = false;
            }
        }

        return ans;
    }

}
