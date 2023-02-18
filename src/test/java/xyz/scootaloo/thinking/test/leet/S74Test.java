package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S74;

/**
 * @author AppleSack
 * @since 2023/02/17
 */
public class S74Test {

    private final S74 solution = new S74();

    @Test
    public void test() {
        System.out.println(solution.searchMatrix(new int[][] {
                { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 }
        }, 7));
    }

}
