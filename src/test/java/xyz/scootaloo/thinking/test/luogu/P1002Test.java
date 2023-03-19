package xyz.scootaloo.thinking.test.luogu;

import xyz.scootaloo.thinking.draft.luogu.P1002;
import xyz.scootaloo.thinking.utils.ToolBox;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/01 - 23:56
 */
public class P1002Test {

    public static void main(String[] args) {
        ToolBox.mock("""
                6 6 3 3
                """);
        P1002.main(ToolBox.EMPTY_ARG);
    }

}
