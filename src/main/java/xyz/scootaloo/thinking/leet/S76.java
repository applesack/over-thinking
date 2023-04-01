package xyz.scootaloo.thinking.leet;

import java.util.Arrays;

/**
 * @author AppleSack
 * @since 2023/03/31
 */
public class S76 {

    private final int[] map = new int[128];
    private final int[] rec = new int[128];
    private boolean over;

    public String minWindow(String s, String t) {
        clear();
        doRecord(t);
        int l = 0, r = 0, len = s.length();
        boolean validResult = false;
        int ansStart = 0, ansEnd = len - 1;
        while (r < len) {
            add(s.charAt(r));
            if (over) {
                while (over && l <= r) {
                    if (r - l <= ansEnd - ansStart) {
                        validResult = true;
                        ansStart = l;
                        ansEnd = r;
                    }
                    del(s.charAt(l++));
                }
            }
            r++;
        }
        if (validResult) {
            return s.substring(ansStart, ansEnd + 1);
        }
        return "";
    }

    private void clear() {
        Arrays.fill(map, 0);
        Arrays.fill(rec, 0);
        over = false;
    }

    private void doRecord(String t) {
        for (int i = 0, len = t.length(); i < len; i++) {
            rec[t.charAt(i)]++;
        }
    }

    private void add(char ch) {
        map[ch]++;
        if (rec[ch] != 0) {
            if (rec[ch] == map[ch]) {
                checkAllOver();
            }
        }
    }

    private void del(char ch) {
        map[ch]--;
        if (rec[ch] != 0) {
            if (rec[ch] > map[ch]) {
                over = false;
            }
        }
    }

    private void checkAllOver() {
        boolean isAllOver = true;
        for (int i = 0, len = rec.length; i < len; i++) {
            if (rec[i] != 0 && map[i] < rec[i]) {
                isAllOver = false;
                break;
            }
        }
        if (isAllOver) {
            over = true;
        }
    }

}
