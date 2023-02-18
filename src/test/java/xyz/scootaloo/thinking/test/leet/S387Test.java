package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S387;

/**
 * @author AppleSack
 * @since 2023/02/06
 */
public class S387Test {

    private final S387 solution = new S387();

    @Test
    public void test() {
        int pos = solution.firstUniqChar("leetcode");
        System.out.println(pos);
    }

    @Test
    public void test1() {
        int pos = solution.firstUniqChar("loveleetcode");
        System.out.println(pos);
    }

    @Test
    public void test2() {
        int pos = solution.firstUniqChar("aabb");
        System.out.println(pos);
    }

}
