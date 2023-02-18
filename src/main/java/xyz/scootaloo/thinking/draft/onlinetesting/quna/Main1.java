package xyz.scootaloo.thinking.draft.onlinetesting.quna;

import java.util.ArrayList;
import java.util.List;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/12 - 16:44
 */
public class Main1 {

    public int compareVersion(String version1, String version2) {
        List<Integer> parts1 = parse(version1);
        List<Integer> parts2 = parse(version2);
        int len = Math.min(parts1.size(), parts2.size());
        for (int i = 0; i < len; i++) {
            if (parts1.get(i) > parts2.get(i)) {
                return 1;
            } else if (parts1.get(i) < parts2.get(i)) {
                return -1;
            }
        }
        return 0;
    }

    private ArrayList<Integer> parse(String version) {
        String[] parts = version.split("\\.");
        ArrayList<Integer> result = new ArrayList<>();
        for (String part : parts) {
            char first = part.charAt(0);
            if (first < '0' || first > '9') {
                return result;
            } else {
                result.add(Integer.parseInt(part));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Main1 main = new Main1();
        System.out.println(main.compareVersion("1.0", "0.1"));
        System.out.println(main.compareVersion("0.1.Alpha", "1.Final"));
    }

}
