package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/01 - 23:45
 */
public class S6197 {

    public static class LUPrefix {

        private int prefix = 0;
        private final boolean[] tasks;

        public LUPrefix(int n) {
            tasks = new boolean[n];
        }

        public void upload(int video) {
            tasks[video - 1] = true;
            update();
        }

        public int longest() {
            return prefix;
        }

        private void update() {
            int max = prefix;
            for (int i = prefix; i< tasks.length; i++) {
                if (!tasks[i]) {
                    break;
                }
                max = i + 1;
            }
            prefix = max;
        }

    }

}
