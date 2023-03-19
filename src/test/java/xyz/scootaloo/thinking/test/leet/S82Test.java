package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S82;
import xyz.scootaloo.thinking.leet.ds.ListNode;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
public class S82Test {

    private final S82 solution = new S82();

    @Test
    public void test() {
        ListNode input = ToolBox.link(1, 2, 3, 3, 4, 4, 5);
        ToolBox.printList(solution.deleteDuplicates(input));
    }

    @Test
    public void test1() {
        ListNode input = ToolBox.link(1, 1);
        ToolBox.printList(solution.deleteDuplicates(input));
    }

    @Test
    public void test2() {
        ListNode input = ToolBox.link(1, 1, 2, 2);
        ToolBox.printList(solution.deleteDuplicates(input));
    }

}
