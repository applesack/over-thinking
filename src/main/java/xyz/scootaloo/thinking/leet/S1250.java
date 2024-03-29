package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/15
 */
public class S1250 {

    public boolean isGoodArray(int[] nums) {
        int g = 0;
        for (int x : nums) {
            g = gcd(x, g);
        }
        return g == 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
