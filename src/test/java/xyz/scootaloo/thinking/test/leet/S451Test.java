package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S451;

/**
 * @author AppleSack
 * @since 2023/02/06
 */
public class S451Test {

    private final S451 solution = new S451();

    @Test
    public void test() {
        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.frequencySort("cccaaa"));
        System.out.println(solution.frequencySort("Aabb"));
    }

}
