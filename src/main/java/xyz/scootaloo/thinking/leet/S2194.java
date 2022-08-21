package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 13:57
 */
public class S2194 {

    public List<String> cellsInRange(String s) {
        String[] parts = s.split(":");
        int left, right, top, bottom;

        left = parts[0].charAt(0) - 'A';
        top = parts[0].charAt(1) - '0';

        right = parts[1].charAt(0) - 'A';
        bottom = parts[1].charAt(1) - '0';

        int row = bottom - top + 1;
        int column = right - left + 1;

        List<String> ans = new ArrayList<>(row * column);
        char[] cell = new char[2];
        for (int c = left; c <= right; c++) {
            for (int r = top; r <= bottom; r++) {
                cell[0] = (char) ('A' + c);
                cell[1] = (char) ('0' + r);
                ans.add(new String(cell));
            }
        }

        return ans;
    }

}
