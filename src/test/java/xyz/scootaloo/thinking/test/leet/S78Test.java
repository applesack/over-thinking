package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S78;

/**
 * @author AppleSack
 * @since 2023/02/24
 */
public class S78Test {

    private final S78 solution = new S78();

    @Test
    public void test() {
        System.out.println(solution.subsets(new int[] { 1, 2, 3 }));
    }

}
