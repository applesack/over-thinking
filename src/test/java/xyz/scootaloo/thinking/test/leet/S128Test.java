package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S128;

/**
 * @author AppleSack
 * @since 2023/03/23
 */
public class S128Test {

    private final S128 solution = new S128();

    @Test
    public void test() {
        System.out.println(solution.longestConsecutive(new int[] {
                100, 4, 200, 1, 3, 2 })); // 4
        System.out.println(solution.longestConsecutive(new int[] {
                0, 3, 7, 2, 5, 8, 4, 6, 0, 1 })); // 9
    }

}
