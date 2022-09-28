package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/24 - 11:11
 */
public class S1652 {

    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            for (int i = 0; i < code.length; i++) {
                if (code[i] != 0) {
                    code[i] = 0;
                }
            }
            return code;
        }

        if (code.length == 1) {
            return code;
        }

        for (int i = 1; i < code.length; i++) {
            code[i] = code[i] + code[i - 1];
        }

        int[] ans = new int[code.length];
        int limit;
        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                limit = Math.min(i + k, code.length - 1);
                ans[i] = code[limit] - code[i];
                if (i + k >= code.length) {
                    ans[i] += code[(i + k) % code.length];
                }
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                limit = Math.max(i + k, 0);
                if (i > 0) {
                    if (limit > 0) {
                        ans[i] = code[i - 1] - code[limit - 1];
                    } else {
                        ans[i] = code[i - 1];
                    }
                }

                if (limit == 0) {
                    ans[i] += code[code.length - 1] - code[code.length - 1 + (i + k)];
                }
            }
        }

        return ans;
    }

}
