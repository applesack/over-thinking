package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0, down = matrix.length - 1, mid, width = matrix[0].length - 1;
        while (up <= down) {
            mid = up + ((down - up) >> 1);
            if (target >= matrix[mid][0] && target <= matrix[mid][width]) {
                return contains(matrix[mid], target);
            } else if (target < matrix[mid][width]) {
                down = mid - 1;
            } else {
                up = mid + 1;
            }
        }
        return false;
    }

    private boolean contains(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

}
