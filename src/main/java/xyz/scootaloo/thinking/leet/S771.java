package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 14:40
 */
public class S771 {

    public int numJewelsInStones(String jewels, String stones) {
        boolean[] map = new boolean[58];
        for (int i = 0; i<jewels.length(); i++) {
            map[jewels.charAt(i) - 'A'] = true;
        }

        int count = 0;
        for (int i = 0; i<stones.length(); i++) {
            if (map[stones.charAt(i) - 'A']) {
                count++;
            }
        }

        return count;
    }

}
