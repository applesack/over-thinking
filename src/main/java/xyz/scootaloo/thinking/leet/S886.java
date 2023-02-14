package xyz.scootaloo.thinking.leet;

import java.util.*;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/16 - 20:05
 */
public class S886 {

    private final Map<Integer, Node> nodeMap = new HashMap<>();

    public boolean possibleBipartition(int n, int[][] dislikes) {
        for (int[] dislike : dislikes) {
            Node a = getOrCreate(dislike[0]);
            Node b = getOrCreate(dislike[1]);
            a.dislike.add(dislike[1]);
            b.dislike.add(dislike[0]);
        }

        for (int i = 1; i<=n; i++) {
            getOrCreate(i).init();
        }

        for (Node node : nodeMap.values()) {
            if (node.arr.length == 0) {
                continue;
            }
            int[] arr = node.arr;
            for (int i = 0; i<arr.length - 1; i++) {
                for (int j = i + 1; j<arr.length; j++) {
                    if (test(arr[i], arr[j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean test(int a, int b) {
        Node node = getOrCreate(a);
        if (Arrays.binarySearch(node.arr, b) < 0) {
            return true;
        }
        node = getOrCreate(b);
        return Arrays.binarySearch(node.arr, a) < 0;
    }

    private Node getOrCreate(int num) {
        Node node = nodeMap.get(num);
        if (node != null) {
            return node;
        }
        node = new Node();
        nodeMap.put(num, node);
        return node;
    }

    private static class Node {

        public List<Integer> dislike = new ArrayList<>();
        private int[] arr;

        public void init() {
            arr = new int[dislike.size()];
            for (int i = 0; i<arr.length; i++) {
                arr[i] = dislike.get(i);
            }
            dislike = null;
            Arrays.sort(arr);
        }

    }

}
