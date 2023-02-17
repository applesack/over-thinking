package xyz.scootaloo.thinking.test.startagain.s1;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.startagain.s1.S1P35;

/**
 * @author applesack
 * @since 2022/12/23 - 16:23
 */
public class S1P35Test {

    private final S1P35 solution = new S1P35();

    @Test
    public void test() {
        System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
    }

}
