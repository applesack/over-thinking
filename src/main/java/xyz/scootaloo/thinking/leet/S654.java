package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/30 - 10:24
 */
public class S654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int max = left;
        for (int i = left; i <= right; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }

        TreeNode root = new TreeNode(nums[max]);
        root.left = buildTree(nums, left, max - 1);
        root.right = buildTree(nums, max + 1, right);

        return root;
    }

}
