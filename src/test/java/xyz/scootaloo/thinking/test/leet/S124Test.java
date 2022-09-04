package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S124;
import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/02 - 10:37
 */
public class S124Test {

    private final S124 solution = new S124();

    @Test
    public void test() {
        TreeNode n10 = new TreeNode(-10);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n10.left = n9;
        n10.right = n20;

        n20.left = n15;
        n20.right = n7;

        System.out.println(solution.maxPathSum(n10));
    }

    @Test
    public void test1() {
        TreeNode n = new TreeNode(-3);
        System.out.println(solution.maxPathSum(n));
    }

    @Test
    public void test2() {
        TreeNode n5 = new TreeNode(5);
        TreeNode n4_1 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n4_2 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);

        n5.left = n4_1;
        n5.right = n8;

        n4_1.left = n11;

        n8.left = n13;
        n8.right = n4_2;

        n11.left = n7;
        n11.right = n2;

        n4_2.right = n1;

        System.out.println(solution.maxPathSum(n5));
    }

    @Test
    public void test3() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(-1);

        n2.left = n1;

        System.out.println(solution.maxPathSum(n2));
    }

}
