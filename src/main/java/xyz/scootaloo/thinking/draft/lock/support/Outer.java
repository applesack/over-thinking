package xyz.scootaloo.thinking.draft.lock.support;

import java.util.Arrays;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 15:05
 */
public class Outer {

    public static String[] pathItems(String path) {
        String[] items = path.split("/");
        if (path.startsWith("/")) {
            if (items.length == 2) {
                return new String[] { items[1] };
            } else {
                String[] newContainer = new String[items.length - 1];
                System.arraycopy(items, 1, newContainer, 0, items.length - 1);
                return newContainer;
            }
        }
        return items;
    }

}
