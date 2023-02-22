package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S117;
import xyz.scootaloo.thinking.leet.ds.Node;

/**
 * @author AppleSack
 * @since 2023/02/22
 */
public class S117Test {

    private final S117 solution = new S117();

    @Test
    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n7;

        Node x = solution.connect(n1);
        System.out.println(x);
    }

}
