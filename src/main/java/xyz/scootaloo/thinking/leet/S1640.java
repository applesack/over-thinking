package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/22 - 9:46
 */
public class S1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        return backtrack(arr, pieces, new boolean[pieces.length], 0);
    }

    private boolean backtrack(int[] arr, int[][] pieces, boolean[] path, int posOfArr) {
        if (posOfArr >= arr.length) {
            return true;
        }

        for (int i = 0; i < path.length; i++) {
            if (path[i]) {
                continue;
            }

            if (pieces[i][0] != arr[posOfArr]) {
                continue;
            }

            boolean broken = false;
            for (int j = 1; j < pieces[i].length; j++) {
                if (arr[posOfArr + j] != pieces[i][j]) {
                    broken = true;
                    break;
                }
            }

            if (broken) {
                continue;
            }

            path[i] = true;

            if (backtrack(arr, pieces, path, posOfArr + pieces[i].length)) {
                return true;
            }

            path[i] = false;
        }

        return false;
    }

}
