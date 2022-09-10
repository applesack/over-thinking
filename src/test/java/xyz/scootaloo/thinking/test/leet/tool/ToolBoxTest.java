package xyz.scootaloo.thinking.test.leet.tool;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.ds.TreeNode;
import xyz.scootaloo.thinking.tool.ToolBox;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/10 - 9:47
 */
public class ToolBoxTest {

    @Test
    public void test() {
        TreeNode node = ToolBox.tree(1, null);
        System.out.println(node);
    }

    @Test
    public void test1() {
        TreeNode node = ToolBox.tree(
                1,
                2, 3,
                4, 5, 6, 7
        );
        System.out.println(node);
    }

    @Test
    public void test2() {
        TreeNode node = ToolBox.tree(
                1,
                null, 2,
                3, 4
        );
        System.out.println(node);
    }

}
