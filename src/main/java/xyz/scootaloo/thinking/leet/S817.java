package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/12 - 11:02
 */
public class S817 {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int count = 0;
        boolean inSeq = false;
        ListNode pointer = head;
        while (pointer != null) {
            int value = pointer.val;
            if (set.contains(value)) {
                if (!inSeq) {
                    inSeq = true;
                    count++;
                }
            } else {
                inSeq = false;
            }
            pointer = pointer.next;
        }

        return count;
    }

}
