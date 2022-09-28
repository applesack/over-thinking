package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/21 - 10:31
 */
@SuppressWarnings("unused")
public class S854 {

    private int result = Integer.MAX_VALUE;

    public int kSimilarity(String s1, String s2) {
        return backtrack(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    private int backtrack(
            final char[] a, final char[] b,
            final int offset, final int current
    ) {
        if (current >= result)
            return result;
        if (offset == a.length - 1)
            return result = current;

        for (int i = offset; i < a.length; i++) {
            if (a[i] == b[i]) {
                continue;
            }
            for (int j = i + 1; j < b.length; j++) {
                if (a[i] == b[j]) {
                    swap(b, i, j);
                    backtrack(a, b, i + 1, current + 1);
                    swap(b, i, j);
                }
            }
            return result;
        }

        return result = current;
    }

    private void swap(final char[] array, final int idxA, final int idxB) {
        final char ch = array[idxA];
        array[idxA] = array[idxB];
        array[idxB] = ch;
    }

}
