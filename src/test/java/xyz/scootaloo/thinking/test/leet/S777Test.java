package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S777;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/02 - 8:40
 */
public class S777Test {

    private final S777 solution = new S777();

    @Test
    public void test() {
        System.out.println(solution.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(solution.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
        System.out.println(solution.canTransform("LLR", "RRL"));
    }

}
