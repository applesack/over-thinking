package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/25
 */
public class S47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        dfs(ans, nums, new boolean[nums.length], new LinkedList<>());
        return ans;
    }

    private void dfs(List<List<Integer>> result,
                     int[] nums, boolean[] visited,
                     LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i<nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.addLast(nums[i]);
            dfs(result, nums, visited, path);
            path.removeLast();
            visited[i] = false;
        }
    }

}
