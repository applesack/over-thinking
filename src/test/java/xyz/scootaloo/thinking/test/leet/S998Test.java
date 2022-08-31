package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S998;
import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/30 - 11:10
 */
public class S998Test {

    private final S998 solution = new S998();

    @Test
    public void test() {
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);

        n5.left = n2;
        n5.right = n4;

        n2.right = n1;

        TreeNode r = solution.insertIntoMaxTree(n5, 3);
        System.out.println(r);
    }

}
