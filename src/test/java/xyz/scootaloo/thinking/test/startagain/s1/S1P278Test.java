package xyz.scootaloo.thinking.test.startagain.s1;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.startagain.s1.S1P278;

/**
 * @author applesack
 * @since 2022/12/23 - 15:50
 */
public class S1P278Test {

    private final S1P278 solution = new S1P278();

    @Test
    public void test() {
        solution.setBadVersion(4);
        System.out.println(solution.firstBadVersion(5));

        solution.setBadVersion(1);
        System.out.println(solution.firstBadVersion(1));

        solution.setBadVersion(1150769282);
        System.out.println(solution.firstBadVersion(1420736637));
    }

}
