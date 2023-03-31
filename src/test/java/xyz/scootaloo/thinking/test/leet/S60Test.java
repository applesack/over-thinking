package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S60;

/**
 * @author AppleSack
 * @since 2023/03/31
 */
public class S60Test {

    private final S60 solution = new S60();

    @Test
    public void test() {
        System.out.println(solution.getPermutation(3, 1));
        System.out.println(solution.getPermutation(3, 2));
        System.out.println(solution.getPermutation(3, 3));
        System.out.println(solution.getPermutation(3, 4));
        System.out.println(solution.getPermutation(3, 5));
        System.out.println(solution.getPermutation(3, 6));
        System.out.println(solution.getPermutation(4, 9));
    }

    @Test
    public void test1() {
        System.out.println(solution.getPermutation(3, 3));
        System.out.println(solution.getPermutation(3, 4));
    }

}
