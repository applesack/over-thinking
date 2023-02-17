package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S162;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S162Test {

    private final S162 solution = new S162();

    @Test
    public void test() {
        System.out.println(solution.findPeakElement(new int[] { 1, 2, 3, 1 }));
        System.out.println(solution.findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
        System.out.println(solution.findPeakElement(new int[] { 1 }));
    }

}
