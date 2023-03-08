package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/03/08
 */
public class S797 {

    private final List<List<Integer>> result = new LinkedList<>();
    private final LinkedList<Integer> path   = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.addLast(0);
        backtrack(graph, 0);
        return result;
    }

    private void backtrack(int[][] graph, int pos) {
        if (pos == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int n : graph[pos]) {
            if (Thread.currentThread().getStackTrace().length > 500) {
                System.out.println(pos);
            }
            path.addLast(n);
            backtrack(graph, n);
            path.removeLast();
        }
    }

}
