package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S654;
import xyz.scootaloo.thinking.leet.ds.TreeNode;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/30 - 10:28
 */
public class S654Test {

    private final S654 solution = new S654();

    @Test
    public void test() {
        int[] input = {3, 2, 1, 6, 0, 5};
        Object r = solution.constructMaximumBinaryTree(input);
        System.out.println(r);
    }

}
