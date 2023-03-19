package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S817;
import xyz.scootaloo.thinking.leet.ds.ListNode;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/12 - 11:07
 */
public class S817Test {

    private final S817 solution = new S817();

    @Test
    public void test() {
        ListNode head = ToolBox.link(1, 2, 3, 4);
        System.out.println(solution.numComponents(head, new int[] { 0, 3, 1, 4 }));
    }

    @Test
    public void test1() {
        ListNode head = ToolBox.link(1, 2, 3);
        System.out.println(solution.numComponents(head, new int[] { 0, 1, 3 }));
    }

}
