package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S47;

/**
 * @author AppleSack
 * @since 2023/02/25
 */
public class S47Test {

    private final S47 solution = new S47();

    @Test
    public void test() {
        System.out.println(solution.permuteUnique(new int[] { 1, 1, 2 }));
        System.out.println(solution.permuteUnique(new int[] { 1, 1, 2, 2 }));
        System.out.println(solution.permuteUnique(new int[] { 1, 2, 3 }));
    }

}
