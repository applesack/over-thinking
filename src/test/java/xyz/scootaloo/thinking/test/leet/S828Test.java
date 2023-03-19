package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S828;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/06 - 19:43
 */
public class S828Test {

    private final S828 solution = new S828();

    @Test
    public void test() {
        String input = "ABC";
        System.out.println(solution.uniqueLetterString(input));
    }

    @Test
    public void test1() {
        String input = ToolBox.read("input/828_1.txt");
        System.out.println("输入长度: " + input.length());
        ToolBox.measureTimeMillis(() -> System.out.println(solution.uniqueLetterString(input)));
    }

}
