package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S687;
import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/02 - 9:27
 */
public class S687Test {

    private final S687 solution = new S687();

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(5);

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;

        System.out.println(solution.longestUnivaluePath(n1));
    }

    @Test
    public void test1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);

        n2.left = n4;
        n2.right = n5;

        n3.right = new TreeNode(5);

        System.out.println(solution.longestUnivaluePath(n1));
    }

}
