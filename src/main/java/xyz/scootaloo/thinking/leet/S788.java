package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/25 - 10:13
 */
public class S788 {

    public int rotatedDigits(int n) {
        int count = 0;
        int[] number = { 0, 0, 0, 0, 1 };
        boolean isValid, containsReverseNum;
        for (int i = 0; i < n; i++) {
            isValid = true;
            containsReverseNum = false;
            for (int j = 0; j < 5; j++) {
                switch (number[j]) {
                    case 2, 5, 6, 9 -> containsReverseNum = true;
                    case 3, 4, 7 -> isValid = false;
                    default -> {
                    }
                }

                if (!isValid) {
                    break;
                }
            }

            if (isValid && containsReverseNum) {
                count++;
            }

            next(number);
        }

        return count;
    }

    private void next(int[] number) {
        int carry = 1, pos = 5 - 1;
        while (carry == 1) {
            if (number[pos] + carry <= 9) {
                number[pos] += carry;
                carry--;
            } else {
                number[pos] = 0;
                pos--;
            }
        }
    }

}
