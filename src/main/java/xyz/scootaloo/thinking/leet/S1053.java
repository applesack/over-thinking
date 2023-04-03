package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.utils.mark.Mark;

/**
 * @author AppleSack
 * @since 2023/04/03
 */
@Mark("todo")
public class S1053 {

    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length, pos = len - 2;
        while (pos >= 0) {
            if (arr[pos] >= arr[pos + 1]) {
                // 在右边找一个小一点的数
                for (int j = len - 1; j > pos; j--) {
                    if (arr[j] < arr[pos]) {
                        int tmp = arr[j];
                        arr[j] = arr[pos];
                        arr[pos] = tmp;
                        return arr;
                    }
                }
            }
            pos--;
        }
        return arr;
    }

}
