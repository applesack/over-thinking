package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/22
 */
public class S547 {

    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] parent = new int[len];
        for (int i = 1; i < len; i++) {
            parent[i] = i;
        }
        for (int i = 0; i<len; i++) {
            for (int j = 0; j<len; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i<len; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    private void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);
    }

    private int find(int[] parent, int i) {
        return parent[i] == i ? i : (parent[i] = find(parent,  parent[i]));
    }

}
