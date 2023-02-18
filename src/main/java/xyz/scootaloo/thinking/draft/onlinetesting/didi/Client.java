package xyz.scootaloo.thinking.draft.onlinetesting.didi;

import xyz.scootaloo.thinking.tool.ToolBox;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/15 - 19:09
 */
public class Client {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        ToolBox.mock("""
                19 10
                0 0 2 2 3 3 4 4 5 5 5 5 5 6 6 6 6 6 6
                """.stripIndent());
        Main1.main(ToolBox.EMPTY_ARG);
    }

}
