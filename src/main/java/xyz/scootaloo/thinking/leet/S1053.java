package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/04/03
 */
public class S1053 {

    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        int min = arr[len - 1];
        int pos = len - 1;
        while (pos >= 0) {
            if (arr[pos] <= min) {
                min = arr[pos];
            } else {
                int minPos = len - 1;
                for (int p = len - 1; p > pos; --p) {
                    if (arr[p] < arr[pos] && arr[p] >= min) {
                        min = arr[p];
                        minPos = p;
                    }
                }
                int tmp = arr[minPos];
                arr[minPos] = arr[pos];
                arr[pos] = tmp;
                return arr;
            }
            --pos;
        }
        return arr;
    }

}
