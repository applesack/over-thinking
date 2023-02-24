package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/19
 */
public class S844 {

    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        StringBuilder buff = new StringBuilder(s.length());
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '#') {
                if (buff.length() > 0) {
                    buff.setLength(buff.length() - 1);
                }
            } else {
                buff.append(ch);
            }
        }
        return buff.toString();
    }

}
