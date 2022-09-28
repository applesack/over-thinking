package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/28 - 9:24
 */
public class SInterview1709 {

    public int getKthMagicNumber(int k) {
        int[] result = new int[k];
        int p3, p5, p7;

        // 初始状态: p3, p5, p7指向最小的丑数
        result[0] = 1;
        p3 = p5 = p7 = 0;

        for (int i = 1; i < k; i++) {
            int resultN = Math.min(Math.min(result[p3] * 3, result[p5] * 5), result[p7] * 7);

            if (resultN % 3 == 0) {
                p3++;
            }
            if (resultN % 5 == 0) {
                p5++;
            }
            if (resultN % 7 == 0) {
                p7++;
            }

            result[i] = resultN;
        }

        return result[k - 1];
    }

}
