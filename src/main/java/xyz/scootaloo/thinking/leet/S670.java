package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/13 - 8:01
 */
public class S670 {

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int len = chars.length;
        int max = sum(chars, len), local;
        char tmp;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;

                local = sum(chars, len);
                if (local > max) {
                    max = local;
                }

                tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
        }

        return max;
    }

    private int sum(char[] array, int len) {
        int sum = array[len - 1] - '0';
        int base = 1;
        for (int i = len - 2; i >= 0; i--) {
            base *= 10;
            sum += base * (array[i] - '0');
        }
        return sum;
    }

}
