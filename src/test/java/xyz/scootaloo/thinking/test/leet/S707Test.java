package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S707;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/23 - 10:16
 */
public class S707Test {

    private final S707 solution = new S707();

    @Test
    public void test() {
        S707.MyLinkedList linkedList = solution.create();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        System.out.println(linkedList);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
    }

    @Test
    public void test1() {
        S707.MyLinkedList linkedList = solution.create();
        linkedList.addAtHead(5);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList);
    }

    @Test
    public void test2() {
        S707.MyLinkedList linkedList = solution.create();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(3, 2);
    }

}
