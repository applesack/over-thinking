package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/10 - 7:41
 */
public class S669 {

    private int low;
    private int high;

    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        return searchAndDelete(root);
    }

    private TreeNode searchAndDelete(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (notInRange(node.val)) {
            node = delete(node);
        }

        if (node == null) {
            return null;
        }

        if (node.left != null) {
            if (notInRange(node.left.val)) {
                node.left = delete(node.left);
            }

            searchAndDelete(node.left);
        }

        if (node.right != null) {
            if (notInRange(node.right.val)) {
                node.right = delete(node.right);
            }

            searchAndDelete(node.right);
        }

        return node;
    }

    private TreeNode delete(TreeNode node) {
        if (node.left == null && node.right == null) {
            return null;
        }

        if (node.left != null) {
            if (!notInRange(node.left.val)) {
                return node.left;
            } else {
                TreeNode l = delete(node.left);
                if (l != null) {
                    return l;
                }
            }
        }

        if (node.right != null && !notInRange(node.right.val)) {
            return node.right;
        } else {
            if (node.right != null) {
                return delete(node.right);
            }
            return null;
        }
    }

    private boolean notInRange(int value) {
        return value > high || value < low;
    }

}
