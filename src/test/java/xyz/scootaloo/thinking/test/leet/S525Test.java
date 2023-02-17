package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S525;

/**
 * @author AppleSack
 * @since 2023/02/14
 */
public class S525Test {

    private final S525 solution = new S525();

    @Test
    public void test() {
        //                                                    0  1  2  3  4
        //                                                   -1  0 -1 -2 -1
        System.out.println(solution.findMaxLength(new int[] { 0, 1, 0, 0, 1 }));

        // 1  0  1  0 -1  0
        // 1  0  1  0  0  1
    }

}
