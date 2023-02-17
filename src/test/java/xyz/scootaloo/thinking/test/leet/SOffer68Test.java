package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.SOffer68;
import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/10 - 0:08
 */
public class SOffer68Test {

    private final SOffer68 solution = new SOffer68();

    @Test
    public void test() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);

        n3.left = n5;
        n3.right =n1;

        n5.left = n6;
        n5.right = n2;

        n1.left = n0;
        n1.right = n8;

        n2.left = n7;
        n2.right = n4;

        System.out.println(solution.lowestCommonAncestor(n3, n5, n1));
    }

}
