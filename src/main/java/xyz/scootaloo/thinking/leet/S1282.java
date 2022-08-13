package xyz.scootaloo.thinking.leet;

import java.util.*;

/**
 * @author flutterdash@qq.com
 * @since 2022/8/12 下午10:48
 */
public class S1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        final Map<Integer, List<Integer>> queuing = new HashMap<>();
        for (int id = 0; id < groupSizes.length; id++) {
            int groupSize = groupSizes[id];
            List<Integer> queue = queuing.computeIfAbsent(groupSize, k -> new LinkedList<>());
            queue.add(id);
        }

        final LinkedList<List<Integer>> result = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : queuing.entrySet()) {
            int groupSize = entry.getKey();
            List<Integer> queue = entry.getValue();
            if (queue.size() == groupSize) {
                result.add(queue);
                continue;
            }

            LinkedList<Integer> tmp = new LinkedList<>();
            for (Integer id : queue) {
                tmp.add(id);
                if (tmp.size() == groupSize) {
                    result.add(new ArrayList<>(tmp));
                    tmp.clear();
                }
            }
        }

        return result;
    }

}
