package xyz.scootaloo.thinking.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/03 - 22:42
 */
public class S6172 {

    public boolean isStrictlyPalindromic(int n) {
        if (n <= 1) {
            return true;
        }
        if (n >= 50) {
            return false;
        }

        int limit = n - 2;
        for (int i = 2; i<=limit; i++) {
            List<Integer> solute = solute(n, i);
            if (!isPalindromic(solute)) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> solute(int n, int radix) {
        LinkedList<Integer> linked = new LinkedList<>();
        while (n > 0) {
            int num = n % radix;
            linked.addFirst(num);
            n /= radix;
        }
        return new ArrayList<>(linked);
    }

    private boolean isPalindromic(List<Integer> list) {
        int half = list.size() / 2;
        int size = list.size() - 1;
        int left, right;
        for (int i = 0; i<half; i++) {
            left = list.get(i);
            right = list.get(size - 1);
            if (left != right) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        S6172 solution = new S6172();
//        System.out.println(solution.solute(10, 1));
        System.out.println(solution.solute(10, 2));
        System.out.println(solution.solute(10, 3));
        System.out.println(solution.solute(10, 4));
    }

}
