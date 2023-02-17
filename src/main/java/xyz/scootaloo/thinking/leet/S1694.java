package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/01 - 9:39
 */
public class S1694 {

    public String reformatNumber(String number) {
        StringBuilder buff = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != ' ' && ch != '-') {
                buff.append(ch);
            }
        }

        int pos = 0;
        LinkedList<String> ans = new LinkedList<>();
        while (pos < buff.length()) {
            int rest = buff.length() - pos;
            if (rest <= 3) {
                ans.add(buff.substring(pos, pos + rest));
                pos += rest;
            } else if (rest == 4) {
                ans.add(buff.substring(pos, pos + 2));
                ans.add(buff.substring(pos + 2, pos + 4));
                pos += 4;
            } else {
                ans.add(buff.substring(pos, pos + 3));
                pos += 3;
            }
        }

        return String.join("-", ans);
    }

}
