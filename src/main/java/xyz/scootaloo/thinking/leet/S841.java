package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author AppleSack
 * @since 2023/03/16
 */
public class S841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(rooms.get(0));
        visited[0] = true;
        while (!queue.isEmpty()) {
            List<Integer> head = queue.poll();
            for (Integer roomNum : head) {
                if (visited[roomNum]) {
                    continue;
                }
                queue.add(rooms.get(roomNum));
                visited[roomNum] = true;
            }
        }

        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }

}
