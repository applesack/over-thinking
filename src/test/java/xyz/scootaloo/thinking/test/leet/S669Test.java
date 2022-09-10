package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S669;
import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/10 - 8:25
 */
public class S669Test {

    private final S669 solution = new S669();

    @Test
    public void test() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n0 = new TreeNode(0);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);

        n3.left = n0;
        n3.right = n4;

        n0.right = n2;
        n2.left = n1;

        TreeNode res = solution.trimBST(n3, 1, 3);
        System.out.println(res);
    }

    @Test
    public void test1() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n2.left = n1;
        n2.right = n3;

        TreeNode res = solution.trimBST(n2, 3, 4);
        System.out.println(res);
    }

}
