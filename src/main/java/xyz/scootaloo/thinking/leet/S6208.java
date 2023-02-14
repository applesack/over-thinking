package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/15 - 22:32
 */
public class S6208 {

    public int countTime(String time) {
        if (!time.contains("?")) {
            return 1;
        }

        return countTime1(time.charAt(0), time.charAt(1)) *
                countTime2(time.charAt(3) == '?', time.charAt(4) == '?');
    }

    private int countTime1(char m, char s) {
        if (m != '?' && s != '?') {
            return 1;
        }

        if (m == '?' && s == '?') {
            return 24;
        }

        if (m == '?') {
            if (s - '0' < 4) {
                return 3;
            } else {
                return 2;
            }
        } else {
            if (m == '1' || m == '0') {
                return 10;
            } else {
                return 4;
            }
        }
    }

    private int countTime2(boolean m, boolean s) {
        if (m && !s) {
            return 6;
        }
        if (!m && s) {
            return 10;
        }
        if (m) {
            return 60;
        }
        return 1;
    }

}
