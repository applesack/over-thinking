package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/31 - 9:31
 */
public class S946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int popPos = 0, top = -1;
        for (int i = 0; i<pushed.length; i++) {
            pushed[++top] = pushed[i];
            while (top >= 0 && popped[popPos] == pushed[top]) {
                top--;
                popPos++;
            }
        }
        return popPos == pushed.length;
    }

}
