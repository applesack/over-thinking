package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/16
 */
public class S1319 {

    private int[] parent;
    private int[] size;
    private int   num;

    private void init(int n) {
        parent = new int[n];
        size = new int[n];
        num = n; // 初始状态，有n个线缆
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int n1, int n2) {
        int x1 = find(n1);
        int x2 = find(n2);
        if (x1 == x2) {
            return;
        }
        // 联通分量数量
        // 现在将两个不相连的分量连接，那么联通分量-1
        num--;
        if (size[x1] < size[x2]) {
            parent[x1] = x2;
            size[x2] += size[x1];
        } else {
            parent[x2] = x1;
            size[x1] += size[x2];
        }
    }

    public int makeConnected(int n, int[][] connections) {
        init(n);
        int cnt = 0; // 多余的线缆数量
        for (int[] conn : connections) {
            int f = conn[0], t = conn[1];
            if (find(f) == find(t)) {
                // 如果f和t归属于同一个父节点，那么f和t存在于同一个联通分量内
                // 那么这个连接(指conn)是多余的
                cnt++;
                continue;
            }
            // 将两个节点联通
            union(f, t);
        }

        // 联通n和分量需要n-1个线缆
        int cnt2 = num - 1;
        if (cnt < cnt2) {
            // 如果可用的线缆少于所需线缆，那么集合不可全部联通
            return -1;
        }
        return cnt2;
    }

}
