package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.TreeNode;

import java.util.*;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/05 - 17:20
 */
@SuppressWarnings("all")
public class S652 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }

    private final Map<String, Pair> seen = new HashMap<>();
    private final Set<TreeNode> repeat = new HashSet<>();
    private int idx;

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int[] tri = { node.val, dfs(node.left), dfs(node.right) };
        String hash = Arrays.toString(tri);
        if (seen.containsKey(hash)) {
            Pair pair = seen.get(hash);
            repeat.add(pair.key);
            return pair.value;
        } else {
            seen.put(hash, new Pair(node, ++idx));
            return idx;
        }
    }

    private static class Pair {

        public TreeNode key;
        public int value;

        public Pair(TreeNode key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}
