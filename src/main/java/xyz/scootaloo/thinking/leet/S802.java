package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.tool.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/03/18
 */
@Tag("spring")
public class S802 {

    private boolean[] finished;
    private boolean[] using;
    private int[][]   graph;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        init(graph);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void init(int[][] graph) {
        int n = graph.length + 1;
        this.graph = graph;
        finished = new boolean[n];
        using = new boolean[n];
    }

    private boolean dfs(int n) {
        if (finished[n]) {
            return using[n];
        }
        if (using[n]) {
            return false;
        }

        using[n] = true;
        boolean allOk = true;
        for (int edge : graph[n]) {
            allOk = allOk && dfs(edge);
        }

        finished[n] = true;
        if (!allOk) {
            using[n] = false;
        }
        return allOk;
    }

}
