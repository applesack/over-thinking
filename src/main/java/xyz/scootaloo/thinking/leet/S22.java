package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/27
 */
public class S22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        dfs(result, n, n, new StringBuilder());
        return result;
    }

    private void dfs(List<String> result, int left, int right, StringBuilder path) {
        if (left == 0 && right == 0) {
            result.add(path.toString());
            return;
        }

        if (left > right) {
            return;
        }
        if (left > 0) {
            path.append('(');
            dfs(result, left - 1, right, path);
            path.setLength(path.length() - 1);
        }
        if (right > 0) {
            path.append(')');
            dfs(result, left, right - 1, path);
            path.setLength(path.length() - 1);
        }
    }

}
