package xyz.scootaloo.thinking.draft.onlinetesting.yuewen;

import xyz.scootaloo.thinking.leet.ds.TreeNode;

import java.util.LinkedList;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/01 - 19:25
 */
public class Solution1 {

    public int findBottomLeftValue(TreeNode root) {
        int count = 1;
        LinkedList<TreeNode> layer = new LinkedList<>();
        LinkedList<TreeNode> nextLayer = new LinkedList<>();
        layer.add(root);
        while (true) {
            int next = 0;
            nextLayer.clear();
            for (int i = 0; i < count; i++) {
                TreeNode head = layer.removeFirst();
                nextLayer.addLast(head);
                if (head.left != null) {
                    layer.addLast(head.left);
                    next++;
                }
                if (head.right != null) {
                    layer.addLast(head.right);
                    next++;
                }
            }
            if (next == 0) {
                break;
            }

            count = next;
        }

        return nextLayer.getFirst().val;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n3.left = n4;
        n3.right = n5;

        System.out.println(solution1.findBottomLeftValue(n1));
    }

}
