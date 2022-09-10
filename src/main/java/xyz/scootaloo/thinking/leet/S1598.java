package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/09 - 8:08
 */
public class S1598 {

    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            }

            if (log.equals("../")) {
                if (depth != 0) {
                    depth--;
                }
            } else {
                depth++;
            }
        }
        return depth;
    }

}
