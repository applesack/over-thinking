package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/11
 */
public class S65 {

    private static final int BEGIN_SIGN   = 1;
    private static final int INTEGER_PART = 2;
    private static final int FLOAT_PART   = 4;
    private static final int SCI_SIGN     = 5;
    private static final int SCI_INTEGER  = 6;

    private char[]  s;
    private int     pos             = 0;
    private boolean skipIntegerPart = false;

    // [+|-] [0~9] [.] [0~9] [e|E] [+|-] [0~9]
    public boolean isNumber(String s) {
        reset(s);
        return isNumber(BEGIN_SIGN);
    }

    private void reset(String s) {
        this.pos = 0;
        this.s = s.toCharArray();
        skipIntegerPart = false;
    }

    private boolean isNumber(int state) {
        char ch;
        switch (state) {
            case BEGIN_SIGN -> {
                if (pos >= s.length) {
                    return false;
                }
                pos = readSign();
                return isNumber(INTEGER_PART);
            }
            case INTEGER_PART -> {
                if (pos >= s.length) {
                    return false;
                }
                int end = readInteger(pos);
                skipIntegerPart = end == pos;
                if (end == s.length) {
                    return true;
                }
                ch = s[pos = end];
                pos++;
                if (ch == '.') {
                    return isNumber(FLOAT_PART);
                }
                if (ch == 'e' || ch == 'E') {
                    if (skipIntegerPart) {
                        return false;
                    }
                    return isNumber(SCI_SIGN);
                }
                return false;
            }
            case FLOAT_PART -> {
                if (pos >= s.length) {
                    return !skipIntegerPart;
                }
                int end = readInteger(pos);
                if (pos == end) {
                    if (!skipIntegerPart && isSciSign(pos)) {
                        pos++;
                        return isNumber(SCI_SIGN);
                    }
                    return false;
                }
                if (end == s.length) {
                    return true;
                }
                pos = end;
                if (isSciSign(pos)) {
                    pos++;
                    return isNumber(SCI_SIGN);
                }
                return false;
            }
            case SCI_SIGN -> {
                if (pos >= s.length) {
                    return false;
                }
                pos = readSign();
                return isNumber(SCI_INTEGER);
            }
            case SCI_INTEGER -> {
                if (pos >= s.length) {
                    return false;
                }
                return readInteger(pos) == s.length;
            }
        }
        return true;
    }

    private int readSign() {
        char ch = s[pos];
        if (ch == '+' || ch == '-') {
            return pos + 1;
        }
        return pos;
    }

    private int readInteger(int start) {
        for (int i = start; i < s.length; i++) {
            char ch = s[i];
            if (!(ch >= '0' && ch <= '9')) {
                return i;
            }
        }
        return s.length;
    }

    private boolean isSciSign(int p) {
        return s[p] == 'e' || s[p] == 'E';
    }

}
