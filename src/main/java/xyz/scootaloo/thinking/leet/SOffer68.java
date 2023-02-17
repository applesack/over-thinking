package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/09 - 23:37
 */
public class SOffer68 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathP = Objects.requireNonNull(findNode(new LinkedList<>(), root, p));
        ArrayList<TreeNode> pathQ = Objects.requireNonNull(findNode(new LinkedList<>(), root, q));
        TreeNode ancestor = pathQ.get(0);
        for (int i = 0; i < pathQ.size(); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                return ancestor;
            } else {
                ancestor = pathP.get(i);
            }
        }
        return ancestor;
    }

    private ArrayList<TreeNode> findNode(LinkedList<TreeNode> path, TreeNode root, TreeNode node) {
        path.add(node);
        if (root == node) {
            return new ArrayList<>(path);
        }

        ArrayList<TreeNode> tmp;
        if (root.left != null) {
            tmp = findNode(path, root.left, node);
            if (tmp != null) {
                return tmp;
            }
        }
        if (root.right != null) {
            tmp = findNode(path, root.right, node);
            if (tmp != null) {
                return tmp;
            }
        }

        path.removeLast();
        return null;
    }

}
