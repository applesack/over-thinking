package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S45;

/**
 * @author AppleSack
 * @since 2023/02/28
 */
public class S45Test {

    private final S45 solution = new S45();

    @Test
    public void test() {
        System.out.println(solution.jump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(solution.jump(new int[] { 2, 3, 0, 1, 4 }));
    }

    @Test
    public void test1() {
        System.out.println(solution.jump(new int[] { 1, 1, 1, 1 }));
    }

}
