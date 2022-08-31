package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/30 - 10:50
 */
public class S998 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        LinkedList<Integer> linked = new LinkedList<>();
        serialize(root, linked);
        ArrayList<Integer> array = new ArrayList<>(linked.size() + 1);
        array.addAll(linked);
        array.add(val);
        linked = null;

        return buildTree(array, 0, array.size() - 1);
    }

    private void serialize(TreeNode root, LinkedList<Integer> receiver) {
        if (root == null) {
            return;
        }
        serialize(root.left, receiver);
        receiver.add(root.val);
        serialize(root.right, receiver);
    }

    private TreeNode buildTree(ArrayList<Integer> nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int max = left;
        for (int i = left; i <= right; i++) {
            if (nums.get(max) < nums.get(i)) {
                max = i;
            }
        }

        TreeNode root = new TreeNode(nums.get(max));
        root.left = buildTree(nums, left, max - 1);
        root.right = buildTree(nums, max + 1, right);

        return root;
    }

}
