package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S55;

/**
 * @author AppleSack
 * @since 2023/02/28
 */
public class S55Test {

    private final S55 solution = new S55();

    @Test
    public void test() {
        System.out.println(solution.canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(solution.canJump(new int[] { 3, 2, 1, 0, 4 }));
    }

}
