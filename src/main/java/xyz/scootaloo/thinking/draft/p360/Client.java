package xyz.scootaloo.thinking.draft.p360;

import xyz.scootaloo.thinking.tool.ToolBox;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/22 - 14:45
 */
public class Client {

    public static void main(String[] args) {
        testMain1_2(args);
    }

    private static void testMain1_1(String[] args) {
        ToolBox.mock("""
                8 1
                1
                2
                3
                4
                5
                6
                7
                8
                """);
        Main1.main(args);
    }

    private static void testMain1_2(String[] args) {
        ToolBox.mock("""
                7 2
                1 3
                2 3
                3 3
                4 3
                5 3
                6 3
                7 3
                """);
        Main1.main(args);
    }

}
