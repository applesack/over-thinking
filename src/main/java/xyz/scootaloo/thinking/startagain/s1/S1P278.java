package xyz.scootaloo.thinking.startagain.s1;

/**
 * @author applesack
 * @since 2022/12/23 - 15:39
 */
public class S1P278 {

    public int firstBadVersion(int n) {
        // 在 1 ~ n 中找到第一个错误的版本
        int l = 0, r = n, midPos;
        while (l <= r) {
            if (r - l <= 5) {
                return linearSearch(l, r);
            }

            midPos = l + (r - l) / 2;
            if (isBadVersion(midPos)) {
                // 出错的版本位于 midPos 之前
                r = midPos;
            } else {
                // 出错的版本位于 midPos 之后
                l = midPos;
            }
        }

        // 没有找到出错的版本
        return -1;
    }

    private int linearSearch(int start, int end) {
        for (int i = start; i<=end; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return end;
    }

    private int theBadVersion = 3;

    public void setBadVersion(int version) {
        this.theBadVersion = version;
    }

    private boolean isBadVersion(int version) {
        return version >= theBadVersion;
    }

}
