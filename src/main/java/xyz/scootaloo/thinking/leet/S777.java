package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/02 - 8:14
 */
public class S777 {

    public boolean canTransform(String start, String end) {
        int startPos = 0, endPos = 0, len = start.length();
        while (true) {
            while (startPos < len && start.charAt(startPos) == 'X') {
                startPos++;
            }
            while (endPos < len && end.charAt(endPos) == 'X') {
                endPos++;
            }

            if (startPos >= len && endPos >= len) {
                return true;
            }
            if (startPos >= len || endPos >= len) {
                return false;
            }
            if (start.charAt(startPos) != end.charAt(endPos)) {
                return false;
            }

            if (start.charAt(startPos) == 'L' && startPos < endPos) {
                return false;
            }
            if (start.charAt(startPos) == 'R' && startPos > endPos) {
                return false;
            }
            startPos++;
            endPos++;
        }
    }

}
