package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.ListNode;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
public class S82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode vHead = new ListNode(0);
        ListNode pre = vHead, cur = head;
        vHead.next = cur;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                // 移动cur到一个不重复的节点
                int value = cur.val;
                while (cur != null && cur.val == value) {
                    cur = cur.next;
                }
                pre.next = cur;
                continue;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return vHead.next;
    }

}
