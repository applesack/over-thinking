package xyz.scootaloo.thinking.leet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/05 - 10:02
 */
public class S811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        Node root = new Node(null);

        for (String cpDomain : cpdomains) {
            int spaceIdx = cpDomain.indexOf(' ');
            if (spaceIdx < 0) {
                continue;
            }

            int count = Integer.parseInt(cpDomain.substring(0, spaceIdx));
            String[] domains = cpDomain.substring(spaceIdx + 1).split("\\.");
            findOrCreate(root, domains, count);
        }

        List<String> result = new LinkedList<>();
        dfsCollectResult(root, result, new LinkedList<>());
        return result;
    }

    private void findOrCreate(Node root, String[] domains, int count) {
        int len = domains.length;
        Node current = root;
        for (int i = len - 1; i >= 0; i--) {
            if (!current.children.containsKey(domains[i])) {
                current.children.put(domains[i], new Node(current));
            }
            current = current.children.get(domains[i]);
        }

        while (current != root) {
            current.count += count;
            current = current.parent;
        }
    }

    private void dfsCollectResult(
            Node node, List<String> result, LinkedList<String> path
    ) {
        if (!path.isEmpty()) {
            collect(result, path, node.count);
        }

        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            path.addFirst(entry.getKey());

            dfsCollectResult(entry.getValue(), result, path);

            path.removeFirst();
        }
    }

    private void collect(List<String> result, LinkedList<String> path, int count) {
        result.add(count + " " + String.join(".", path));
    }

    private static class Node {
        int count = 0;
        final Node parent;
        final Map<String, Node> children = new HashMap<>();

        public Node(Node parent) {
            this.parent = parent;
        }
    }

}
