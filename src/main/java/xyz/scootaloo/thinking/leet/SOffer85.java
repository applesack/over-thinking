package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;
import java.util.List;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 20:15
 */
public class SOffer85 {

    public List<String> generateParenthesis(int n) {
        List<String> results = new LinkedList<>();
        generate(results, new StringBuilder(), 0, 0, n);
        return results;
    }

    private void generate(
            List<String> receiver, StringBuilder buff,
            int l, int r, int n
    ) {
        if (l + r == n * 2) {
            receiver.add(buff.toString());
            return;
        }
        if (l < n) {
            buff.append('(');
            generate(receiver, buff, l + 1, r, n);
            buff.deleteCharAt(buff.length() - 1);
        }
        if (r < l) {
            buff.append(')');
            generate(receiver, buff, l, r + 1, n);
            buff.deleteCharAt(buff.length() - 1);
        }
    }

}
