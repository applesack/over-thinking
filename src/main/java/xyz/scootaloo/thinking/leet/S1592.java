package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 7:44
 */
public class S1592 {

    public String reorderSpaces(String text) {
        List<String> words = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        int space = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                space++;
                if (!builder.isEmpty()) {
                    words.add(builder.toString());
                    builder.setLength(0);
                }
            } else {
                builder.append(ch);
            }
        }
        if (!builder.isEmpty()) {
            words.add(builder.toString());
        }

        words = new ArrayList<>(words);
        builder.setLength(0);
        if (words.size() == 1) {
            builder.append(words.get(0));
            builder.append(" ".repeat(space));
        } else {
            int inGap = (space / (words.size() - 1));

            for (int i = 0; i < words.size() - 1; i++) {
                builder.append(words.get(i));
                builder.append(" ".repeat(inGap));
            }
            builder.append(words.get(words.size() - 1));

            if (inGap * (words.size() - 1) != space) {
                int rest = space - (inGap * (words.size() - 1));
                builder.append(" ".repeat(rest));
            }
        }

        return builder.toString();
    }

}
