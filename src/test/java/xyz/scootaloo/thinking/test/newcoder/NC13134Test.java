package xyz.scootaloo.thinking.test.newcoder;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.draft.newcoder.NC13134;
import xyz.scootaloo.thinking.tool.ToolBox;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/01 - 12:12
 */
public class NC13134Test {

    @Test
    public void test() {
        ToolBox.mock("""
                6
                7 2 3 1 5 6
                """);
        NC13134.main(ToolBox.EMPTY_ARG);
    }

    @Test
    public void test1() {
        ToolBox.mock("""
                6
                7 2 6 4 5 6
                """);
        NC13134.main(ToolBox.EMPTY_ARG);
    }

    @Test
    public void test2() {
        ToolBox.mock("""
                5
                1 2 3 9 5
                """);
        NC13134.main(ToolBox.EMPTY_ARG);
    }

    @Test
    public void test3() {
        ToolBox.mock("""
                5
                1 2 3 4 5
                """);
        NC13134.main(ToolBox.EMPTY_ARG);
    }

}
