package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/02 - 10:27
 */
public class S124 {

    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        solute(root);
        return max;
    }

    private int solute(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = solute(root.left);
        int right = solute(root.right);

        int local = max(
                root.val,
                root.val + left,
                root.val + right
        );
        if (local > max) {
            max = local;
        }
        if (root.val + left + right > max) {
            max = root.val + left + right;
        }

        return local;
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

}
