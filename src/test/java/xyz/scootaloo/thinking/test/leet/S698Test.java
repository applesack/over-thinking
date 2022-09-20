package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S698;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/20 - 8:03
 */
public class S698Test {

    private final S698 solution = new S698();

    @Test
    public void test() {
        System.out.println(solution.canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4));
        System.out.println(solution.canPartitionKSubsets(new int[] { 1, 2, 3, 4 }, 3));
    }

    @Test
    public void test1() {
        int[] input = { 129, 17, 74, 57, 1421, 99, 92, 285, 1276, 218, 1588, 215, 369, 117, 153, 22 };
        System.out.println(solution.canPartitionKSubsets(input, 3));
    }

    @Test
    public void test2() {
        int[] input = { 1, 1, 1, 1, 2, 2, 2, 2 };
        System.out.println(solution.canPartitionKSubsets(input, 4));
    }

}
