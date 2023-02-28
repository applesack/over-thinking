package xyz.scootaloo.thinking.leet;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/26
 */
public class S17 {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        String[] words = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            if (ch == '2') {
                words[i] = "abc";
            } else if (ch == '3') {
                words[i] = "def";
            } else if (ch == '4') {
                words[i] = "ghi";
            } else if (ch == '5') {
                words[i] = "jkl";
            } else if (ch == '6') {
                words[i] = "mno";
            } else if (ch == '7') {
                words[i] = "pqrs";
            } else if (ch == '8') {
                words[i] = "tuv";
            } else {
                words[i] = "wxyz";
            }
        }

        LinkedList<String> ans = new LinkedList<>();
        dfs(ans, words, 0, new StringBuilder());
        return ans;
    }

    private void dfs(List<String> result, String[] words, int pos, StringBuilder path) {
        if (pos == words.length) {
            result.add(path.toString());
            return;
        }
        String word = words[pos];
        for (int i = 0; i < word.length(); i++) {
            path.append(word.charAt(i));
            dfs(result, words, pos + 1, path);
            path.setLength(path.length() - 1);
        }
    }

}
