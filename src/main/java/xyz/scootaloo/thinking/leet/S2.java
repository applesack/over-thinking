package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.ListNode;

/**
 * @author AppleSack
 * @since 2023/02/16
 */
public class S2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode vHead = new ListNode(0);
        ListNode p = vHead;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            p.next = new ListNode(sum > 9 ? sum - 10 : sum);
            p = p.next;
            if (sum > 9) {
                sum = 1;
                continue;
            }
            sum = 0;
        }
        if (sum != 0) {
            p.next = new ListNode(sum);
        }
        return vHead.next;
    }

}
