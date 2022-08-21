package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S771;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/21 - 14:47
 */
public class S771Test {

    private final S771 solution = new S771();

    @Test
    public void test() {
        String jewels = "aA";
        String stones = "aAAbbbb";
        assert solution.numJewelsInStones(jewels, stones) == 3;
    }

    @Test
    public void test1() {
        String jewels = "z";
        String stones = "ZZ";
        assert solution.numJewelsInStones(jewels, stones) == 0;
    }

}
