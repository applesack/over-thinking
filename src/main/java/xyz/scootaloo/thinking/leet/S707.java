package xyz.scootaloo.thinking.leet;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/23 - 9:48
 */
public class S707 {

    public MyLinkedList create() {
        return new MyLinkedList();
    }

    public static class MyLinkedList {

        private int size;
        private final Node head = new Node(0);
        private final Node tail = new Node(0);

        public MyLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }

            int pos = 0;
            Node current = head.next;
            while (pos < index) {
                current = current.next;
                pos++;
            }

            return current.value;
        }

        public void addAtHead(int val) {
            bind(head, head.next, val);
        }

        public void addAtTail(int val) {
            bind(tail.prev, tail, val);
        }

        public void addAtIndex(int index, int val) {
            if (index == size) {
                addAtTail(val);
                return;
            }

            if (index > size) {
                return;
            }

            if (index <= 0) {
                addAtHead(val);
                return;
            }

            int pos = 0;
            Node current = head;
            while (pos < index) {
                current = current.next;
                pos++;
            }

            bind(current, current.next, val);
        }

        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }

            int pos = 0;
            Node current = head;
            while (pos < index) {
                current = current.next;
                pos++;
            }

            current.next = current.next.next;
            current.next.prev = current;

            size--;
        }

        private void bind(Node h, Node t, int val) {
            Node node = new Node(val);
            node.next = t;
            node.prev = h;

            t.prev = node;
            h.next = node;

            size++;
        }

        @Override
        public String toString() {
            int[] array = new int[size];

            Node pos = head.next;
            int index = 0;
            while (pos != tail) {
                array[index++] = pos.value;
                pos = pos.next;
            }

            return Arrays.toString(array);
        }

        private static class Node {

            int value;
            Node next;
            Node prev;

            public Node(int value) {
                this.value = value;
            }

        }

    }

}
