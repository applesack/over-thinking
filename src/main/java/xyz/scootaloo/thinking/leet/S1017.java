package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/04/06
 */
public class S1017 {

    // 0  1 2  3  4   5  6    7   8    9
    // 1 -2 4 -8 16 -32 64 -128 256 -512
    // 0 => 0
    // 1 => 1
    // 2 => 110
    // 3 =>
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }

        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            int remain = n & 1; // 取最右一位
            builder.append(remain);
            n -= remain;
            n /= -2;
        }
        return builder.reverse().toString();
    }

}
