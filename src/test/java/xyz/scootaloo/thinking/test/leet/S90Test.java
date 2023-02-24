package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S90;

/**
 * @author AppleSack
 * @since 2023/02/24
 */
public class S90Test {

    private final S90 solution = new S90();

    @Test
    public void test() {
        System.out.println(solution.subsetsWithDup(new int[] { 1, 2, 2 }));
    }

}
