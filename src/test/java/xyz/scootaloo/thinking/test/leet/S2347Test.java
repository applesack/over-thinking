package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S2347;

/**
 * @author AppleSack
 * @since 2023/02/20
 */
public class S2347Test {

    private final S2347 solution = new S2347();

    @Test
    public void test() {
        System.out.println(solution.bestHand(new int[] { 13, 2, 3, 1, 9 }, new char[] { 'a', 'a', 'a', 'a', 'a' }));
        System.out.println(solution.bestHand(new int[] { 4, 4, 2, 4, 4 }, new char[] { 'd', 'a', 'a', 'b', 'c' }));
        System.out.println(solution.bestHand(new int[] { 10, 10, 2, 12, 9 }, new char[] { 'a', 'b', 'c', 'a', 'd' }));
    }

}
