package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author AppleSack
 * @since 2023/02/22
 */
public class S576 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return serialize(new StringBuilder(), root).toString()
                .contains(serialize(new StringBuilder(), subRoot));
    }

    private StringBuilder serialize(StringBuilder builder, TreeNode root) {
        if (root == null) {
            builder.append(".");
            return builder;
        }
        builder.append('[');
        serialize(builder, root.left);
        builder.append(root.val);
        serialize(builder, root.right);
        builder.append(']');
        return builder;
    }

//    private boolean dfs(TreeNode root, TreeNode other) {
//        if (root == null) {
//            return false;
//        }
//        return check(root, other) || dfs(root.left, other) || dfs(root.right, other);
//    }
//
//    private boolean check(TreeNode root, TreeNode other) {
//        if (root == null && other == null) {
//            return true;
//        }
//        if (root == null || other == null || root.val != other.val) {
//            return false;
//        }
//        return check(root.left, other.left) && check(root.right, other.right);
//    }

}
