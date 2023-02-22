package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S576;
import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author AppleSack
 * @since 2023/02/22
 */
public class S576Test {

    private final S576 solution = new S576();

    @Test
    public void test() {
        TreeNode t13 = new TreeNode(3);
        TreeNode t14 = new TreeNode(4);
        TreeNode t15 = new TreeNode(5);
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);

        t13.left = t14;
        t13.right = t15;

        t14.left = t11;
        t14.right = t12;

        TreeNode t24 = new TreeNode(4);
        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);

        t24.left = t21;
        t24.right = t22;

        System.out.println(solution.isSubtree(t13, t24));
    }

    @Test
    public void test1() {
        TreeNode t13 = new TreeNode(3);
        TreeNode t14 = new TreeNode(4);
        TreeNode t15 = new TreeNode(5);
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t10 = new TreeNode(0);

        t13.left = t14;
        t13.right = t15;

        t14.left = t11;
        t14.right = t12;

        t12.left = t10;

        TreeNode t24 = new TreeNode(4);
        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);

        t24.left = t21;
        t24.right = t22;

        System.out.println(solution.isSubtree(t13, t24));
    }

    @Test
    public void test3() {
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t13 = new TreeNode(3);

        t11.left = t12;
        t11.right = t13;

        TreeNode t21 = new TreeNode(1);

        t21.left = new TreeNode(2);

        System.out.println(solution.isSubtree(t11, t21));
    }

}
