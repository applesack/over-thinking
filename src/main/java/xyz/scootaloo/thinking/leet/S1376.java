package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/18
 */
public class S1376 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        boolean[] visited = new boolean[n];
        int max = informTime[headID];
        visited[headID] = true;
        for (int i = 0; i < n; i++) {
            if (i == headID) {
                continue;
            }
            max = Math.max(max, find(visited, manager, informTime, manager[i]));
        }
        return max;
    }

    private int find(boolean[] visited, int[] manager, int[] informTime, int i) {
        if (visited[i]) {
            return informTime[i];
        }
        visited[i] = true;
        informTime[i] += find(visited, manager, informTime, manager[i]);
        return informTime[i];
    }

}
