package xyz.scootaloo.thinking.leet;

import java.util.HashSet;

/**
 * @author AppleSack
 * @since 2023/02/15
 */
public class LCP03 {

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        HashSet<Long> obSet = new HashSet<>();
        for (int[] ob : obstacles) {
            obSet.add(compress(ob[1], ob[0]));
        }
        long target = compress(y, x);
        int r = 0, c = 0, pos = 0;
        do {
            long current = compress(r, c);
            if (current == target) {
                return true;
            }
            if (obSet.contains(current)) {
                return false;
            }
            if (command.charAt(pos++) == 'U') {
                r++;
            } else {
                c++;
            }
            if (r > y || c > x) {
                return false;
            }
            if (pos == command.length()) {
                pos = 0;
            }
        } while (true);
    }

    private long compress(long r, long c) {
        final long base = 1L << 60;
        return base + (r << 30) + c;
    }

}
