package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/24
 */
public class S90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new boolean[nums.length], 0, new LinkedList<>());
        return result;
    }

    private void dfs(
            List<List<Integer>> result, int[] nums, boolean[] visited,
            int pos, LinkedList<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            if (visited[pos]) {
                continue;
            }

            // 考虑下面这种情况
            // 1 2 2 原数组
            // 1 2
            // 1   2
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            visited[i] = true;
            dfs(result, nums, visited, i + 1, path);
            visited[i] = false;
            path.removeLast();
        }
    }

}
