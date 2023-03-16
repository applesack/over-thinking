package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/03/11
 */
public class S68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> middle = middleResult(words, maxWidth);
        return finalResult(middle, maxWidth);
    }

    private List<List<String>> middleResult(String[] words, int maxWidth) {
        List<List<String>> result = new LinkedList<>();
        List<String> line = new LinkedList<>();
        int count = 0, len = 0;
        for (int i = 0; i < words.length; i++) {
            if (canPlaceInLine(count, len, maxWidth, words[i])) {
                line.add(words[i]);
                count++;
                len += words[i].length();
            } else {
                result.add(new ArrayList<>(line));
                line.clear();
                count = len = 0;
                i--;
            }
        }
        if (!line.isEmpty()) {
            result.add(new ArrayList<>(line));
        }
        return result;
    }

    private boolean canPlaceInLine(int count, int len, int maxWidth, String str) {
        count += 1;
        len += str.length();
        return count + len - 1 <= maxWidth;
    }

    private List<String> finalResult(List<List<String>> middle, int maxWidth) {
        List<String> result = new ArrayList<>(middle.size());
        for (int i = 0; i < middle.size(); i++) {
            List<String> line = middle.get(i);
            if (i == middle.size() - 1) {
                result.add(leftAlignment(line, maxWidth));
            } else {
                result.add(centerAlignment(line, maxWidth));
            }
        }
        return result;
    }

    private String centerAlignment(List<String> line, int maxWidth) {
        if (line.size() == 1) {
            return leftAlignment(line, maxWidth);
        }
        int spaceCount = maxWidth - getSize(line);
        int[] gaps = new int[line.size() - 1];
        int pos = 0;
        while (spaceCount > 0) {
            gaps[pos++]++;
            if (pos == gaps.length) {
                pos = 0;
            }
            spaceCount--;
        }

        StringBuilder builder = new StringBuilder(maxWidth);
        builder.append(line.get(0));
        for (int i = 1; i<line.size(); i++) {
            builder.append(" ".repeat(gaps[i - 1]));
            builder.append(line.get(i));
        }
        return builder.toString();
    }

    private String leftAlignment(List<String> line, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        for (String word : line) {
            builder.append(word);
            builder.append(' ');
        }
        if (builder.length() > maxWidth) {
            builder.setLength(maxWidth);
        } else {
            builder.append(" ".repeat(maxWidth - builder.length()));
        }
        return builder.toString();
    }

    private int getSize(List<String> line) {
        int count = 0;
        for (String word : line) {
            count += word.length();
        }
        return count;
    }

}
