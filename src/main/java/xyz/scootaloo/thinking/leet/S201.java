package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/07
 */
public class S201 {

    public int rangeBitwiseAnd(int left, int right) {
        // 前面相同的部分(前缀)计算结果不变, 后面的结果全部为0
        // 101    10    1
        // 111 => 11 => 1 => 100
        int prefix = 0;
        while (left < right) {
            left = left >> 1;
            right = right >> 1;
            prefix++;
        }
        return left << prefix;
    }

}
