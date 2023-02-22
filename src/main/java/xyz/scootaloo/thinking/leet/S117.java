package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/22
 */
public class S117 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        int levelCount = 1, nextLevel;

        while (!deque.isEmpty()) {
            List<Node> level = new ArrayList<>(levelCount);
            nextLevel = 0;
            for (int i = 0; i < levelCount; i++) {
                Node head = deque.removeFirst();
                level.add(head);
                if (head.left != null) {
                    nextLevel++;
                    deque.addLast(head.left);
                }
                if (head.right != null) {
                    nextLevel++;
                    deque.addLast(head.right);
                }
            }
            for (int i = 0; i < level.size() - 1; i++) {
                level.get(i).next = level.get(i + 1);
            }
            levelCount = nextLevel;
        }

        return root;
    }

}
