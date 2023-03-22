package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/03/22
 */
public class S1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] used = new boolean[n];
        for (List<Integer> edge : edges) {
            used[edge.get(1)] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                ans.add(i);
            }
        }
        return ans;
    }


}
