package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/25
 */
public class S40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, candidates, new boolean[candidates.length],
                0, 0, target, new LinkedList<>());
        return result;
    }

    private void dfs(List<List<Integer>> result,
                     int[] nums, boolean[] visited,
                     int pos, int sum, int target,
                     LinkedList<Integer> path) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            int tmpSum = sum + nums[i];
            if (tmpSum > target) {
                break;
            }

            visited[i] = true;
            path.addLast(nums[i]);
            dfs(result, nums, visited, i + 1, tmpSum, target, path);
            path.removeLast();
            visited[i] = false;
        }
    }

}
