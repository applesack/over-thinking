package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/02 - 10:30
 */
public class S6192 {

    public int commonFactors(int a, int b) {
        if (a > b) {
            return commonFactors0(a, b);
        } else {
            return commonFactors0(b, a);
        }
    }

    private int commonFactors0(int max, int min) {
        int count = 0;
        for (int i = 1; i<=min; i++) {
            if (max % i == 0 && min % i == 0) {
                count++;
            }
        }
        return count;
    }

}
