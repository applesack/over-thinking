package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S886;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/16 - 20:35
 */
public class S886Test {

    private final S886 solution = new S886();

    @Test
    public void test() {
        System.out.println(solution.possibleBipartition(4, ToolBox.parse2dIntArray("""
                [[1,2],[1,3],[2,4]]
                """))); // true

        System.out.println(solution.possibleBipartition(3, ToolBox.parse2dIntArray("""
                [[1,2],[1,3],[2,3]]
                """))); // false

        System.out.println(solution.possibleBipartition(5, ToolBox.parse2dIntArray("""
                [[1,2],[2,3],[3,4],[4,5],[1,5]]
                """))); // false
    }

    @Test
    public void test1() {
        System.out.println(solution.possibleBipartition(3, ToolBox.parse2dIntArray("""
                [[1,2],[1,3],[2,3]]
                """))); // false
    }

}
