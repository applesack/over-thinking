package xyz.scootaloo.thinking.tool;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/06 - 20:17
 */
public class ToolBox {

    private static final Object lock = new Object();

    private static volatile Vertx vertx;

    private static Vertx getVertx() {
        Vertx ins = vertx;
        if (ins == null) {
            synchronized (lock) {
                if (vertx == null) {
                    vertx = Vertx.vertx();
                }
                ins = vertx;
            }
        }
        return ins;
    }

    public static String read(String file) {
        final Vertx vertx = getVertx();
        final FileSystem fs = vertx.fileSystem();
        final Buffer buff = fs.readFileBlocking(file);
        return buff.getString(0, buff.length());
    }

    public static void measureTimeMillis(Runnable block) {
        long start = System.currentTimeMillis();
        block.run();
        long end = System.currentTimeMillis();
        String builder = "执行用时: " + ((end - start) / 1000.0) + "秒";
        System.out.println(builder);
    }

}
