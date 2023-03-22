package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.utils.mark.Modify;
import xyz.scootaloo.thinking.utils.mark.Tag;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/16 - 20:05
 */
@Tag({"并查集", "反向点"})
public class S886 {

    private int[] parent;

    @Modify("2023/3/22")
    public boolean possibleBipartition(int n, int[][] dislikes) {
        init(n * 2);
        for (int[] dislike : dislikes) {
            int a = dislike[0], b = dislike[1];
            // 如果a和b联通，那么不符合条件，无法分组
            if (isConnect(a, b)) return false;
            // 在最开始的时候，所有的数字都没有分组，也没有归属(n只归属与n)
            // 当构建第一个dislike的时候，需要描述a和b不在一个集合中，这里a和b不能直接相连
            // 所以把a连接到一个点上，这个点不会对前面的点(0~n)产生影响，这个连接表示a和!b处于一个集合

            // 当输入为[[1,2][1,3]]时，生成的连接为 1<-!2, 1<-!3，此时1,!2,!3处于一个集合
            // 当新的输入为[2,3]时，需要建立2<-!3的连接，此时2在!1和!3的集合中，而
            union(a, b + n); // a->!b
            union(b, a + n); // b->!a
        }
        return true;
    }

    private void init(int n) {
        parent = new int[n + 1];
        for (int i = 0; i<=n; i++) {
            parent[i] = i;
        }
    }

    private boolean isConnect(int a, int b) {
        return find(a) == find(b);
    }

    private void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    private int find(int a) {
        return parent[a] == a ? a : (parent[a] = find(parent[a]));
    }

}
