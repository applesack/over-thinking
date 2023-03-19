package xyz.scootaloo.thinking.leet;

import java.util.*;

/**
 * @author AppleSack
 * @since 2023/03/18
 */
public class S1466 {

    public int minReorder(int n, int[][] connections) {
        // 以i为起点
        Map<Integer, List<Integer>> start = new HashMap<>();
        // 以i为终点
        Map<Integer, List<Integer>> end = new HashMap<>();
        boolean[] used = new boolean[n];
        for (int[] conn : connections) {
            addTo(start, conn[0], conn[1]);
            addTo(end, conn[1], conn[0]);
        }

        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int head = queue.poll();
            used[head] = true;
            List<Integer> s2e = start.get(head);
            List<Integer> e2s = end.get(head);
            if (s2e != null) {
                for (Integer endpoint : s2e) {
                    if (!used[endpoint]) {
                        ans++;
                        queue.add(endpoint);
                    }
                }
            }
            if (e2s != null) {
                for (Integer endpoint : e2s) {
                    if (!used[endpoint]) {
                        queue.add(endpoint);
                    }
                }
            }
        }
        return ans;
    }

    private void addTo(Map<Integer, List<Integer>> map, Integer key, Integer value) {
        List<Integer> list = map.getOrDefault(key, new ArrayList<>());
        list.add(value);
        map.put(key, list);
    }

}
