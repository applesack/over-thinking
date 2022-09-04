package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/02 - 8:47
 */
public class S687 {

    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        max = 0;

        dfs(root, root.val);

        return max;
    }

    private int dfs(TreeNode root, int value) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        max = Math.max(max, left + right);
        if (root.val == value) {
            return Math.max(left, right) + 1;
        }

        return 0;
    }

}
