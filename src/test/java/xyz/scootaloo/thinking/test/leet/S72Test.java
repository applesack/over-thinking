package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S72;

/**
 * @author AppleSack
 * @since 2023/03/08
 */
public class S72Test {

    private final S72 solution = new S72();

    @Test
    public void test() {
        System.out.println(solution.minDistance("horse", "ros"));
        System.out.println(solution.minDistance("intention", "execution"));
    }

}
