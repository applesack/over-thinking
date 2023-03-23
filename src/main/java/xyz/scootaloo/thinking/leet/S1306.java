package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/19
 */
public class S1306 {

    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        arr[start] = -arr[start];
        return canReach(arr, start - arr[start]) || canReach(arr, start + arr[start]);
    }


}
