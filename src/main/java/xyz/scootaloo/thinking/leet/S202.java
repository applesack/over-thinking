package xyz.scootaloo.thinking.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AppleSack
 * @since 2023/03/07
 */
public class S202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            n = getNext(n);
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
    }

    private int getNext(int n) {
        int num = 0, rest;
        while (n > 0) {
            rest = n % 10;
            num += rest * rest;
            n /= 10;
        }
        return num;
    }

}
