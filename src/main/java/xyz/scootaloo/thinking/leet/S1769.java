package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 14:58
 */
public class S1769 {

    public int[] minOperations(String boxes) {
        int[] left = new int[boxes.length()];
        int[] right = new int[boxes.length()];
        int count;

        count = boxes.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < boxes.length(); i++) {
            left[i] = left[i - 1] + count;
            if (boxes.charAt(i) == '1') {
                count++;
            }
        }

        count = boxes.charAt(boxes.length() - 1) == '1' ? 1 : 0;
        for (int i = boxes.length() - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            if (boxes.charAt(i) == '1') {
                count++;
            }
        }

        int[] ans = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            ans[i] = left[i] + right[i];
        }

        return ans;
    }

}
