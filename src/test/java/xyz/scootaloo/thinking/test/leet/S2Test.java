package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S2;
import xyz.scootaloo.thinking.leet.ds.ListNode;
import xyz.scootaloo.thinking.tool.ToolBox;

/**
 * @author AppleSack
 * @since 2023/02/16
 */
public class S2Test {

    private final S2 solution = new S2();

    @Test
    public void test() {
        ListNode l1 = ToolBox.link(2, 4, 3);
        ListNode l2 = ToolBox.link(5, 6, 4);
        ToolBox.printList(solution.addTwoNumbers(l1, l2));
    }

    @Test
    public void test2() {
        ListNode l1 = ToolBox.link(9, 9, 9, 9, 9, 9, 9);
        ListNode l2 = ToolBox.link(9, 9, 9, 9);
        ToolBox.printList(solution.addTwoNumbers(l1, l2));
    }

}
