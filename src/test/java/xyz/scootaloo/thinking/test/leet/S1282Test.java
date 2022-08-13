package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S1282;

import java.util.List;

/**
 * @author flutterdash@qq.com
 * @since 2022/8/12 下午11:03
 */
public class S1282Test {

    private final S1282 solution = new S1282();

    @Test
    public void test() {
        int[] input = {3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> result = solution.groupThePeople(input);
        System.out.println(result);
    }

}
