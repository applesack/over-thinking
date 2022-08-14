package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/8/14 下午3:06
 */
public class S1422 {

    public int maxScore(String s) {
        int oneCount = 0;
        int zeroCount = 0;

        for (int idx = 0; idx < s.length(); ++idx) {
            if (s.charAt(idx) == '1') {
                oneCount++;
            }
        }

        int max = Integer.MIN_VALUE;
        int sum;
        int rightLimit = s.length() - 1;
        for (int idx = 0; idx < rightLimit; ++idx) {
            if (s.charAt(idx) == '0') {
                zeroCount++;
            } else {
                oneCount--;
            }
            sum = zeroCount + oneCount;
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

}
