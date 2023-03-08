package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/03/08
 */
public class S149 {

    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int ans = 0;
        int len = points.length;
        for (int i = 0; i < (len - 2); i++) {
            for (int j = i + 1; j < (len - 1); j++) {
                int x1 = points[i][0] - points[j][0];
                int y1 = points[i][1] - points[j][1];
                int count = 2;
                for (int k = j + 1; k < len; k++) {
                    int x2 = points[i][0] - points[k][0];
                    int y2 = points[i][1] - points[k][1];
                    if (x1 * y2 == x2 * y1) {
                        count++;
                    }
                }
                if (count > ans) {
                    ans = count;
                }
            }
        }
        return ans;
    }

}
