package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/24
 */
public class S78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(10);
        search(result, nums, 0, new LinkedList<>());
        return result;
    }

    private void search(
            List<List<Integer>> result, int[] nums, int pos, LinkedList<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            path.addLast(nums[i]);
            search(result, nums, i + 1, path);
            path.removeLast();
        }
    }

}
