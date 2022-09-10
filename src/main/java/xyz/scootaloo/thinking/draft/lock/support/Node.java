package xyz.scootaloo.thinking.draft.lock.support;

import org.jetbrains.annotations.Nullable;
import xyz.scootaloo.thinking.draft.lock.BaseLock;

import java.util.HashMap;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 15:24
 */
public class Node {

    public String name;

    public Node parent;

    public BaseLock lock;

    public final HashMap<String, Node> children = new HashMap<>();

    public Node(String name, @Nullable Node parent) {
        this.name = name;
        this.parent = parent;
    }

}
