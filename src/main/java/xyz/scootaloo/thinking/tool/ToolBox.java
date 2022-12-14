package xyz.scootaloo.thinking.tool;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;
import xyz.scootaloo.thinking.leet.ds.TreeNode;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/06 - 20:17
 */
public class ToolBox {

    private static final Object lock = new Object();

    private static volatile Vertx vertx;

    private ToolBox() {
    }

    public static String read(String file) {
        final Vertx vertx = getVertx();
        final FileSystem fs = vertx.fileSystem();
        final Buffer buff = fs.readFileBlocking(file);
        return buff.getString(0, buff.length());
    }

    public static int[] readIntArray(String file) {
        final String text = read(file);
        return parseIntArray(text);
    }

    public static TreeNode tree(Integer... nums) {
        List<Integer> list = Stream.of(nums).toList();
        if (list.isEmpty() || list.size() == 1 && list.get(0) == null) {
            return null;
        }

        TreeNode root = new TreeNode(nums[0]);
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        current.addLast(root);
        int pos = 1;

        while (pos < nums.length) {
            for (TreeNode node : current) {
                Integer leftValue = nums[pos++];
                if (pos < nums.length) {
                    if (leftValue != null) {
                        node.left = new TreeNode(leftValue);
                        next.addLast(node.left);
                    }
                }

                if (pos < nums.length) {
                    Integer rightValue = nums[pos++];
                    if (rightValue != null) {
                        node.right = new TreeNode(rightValue);
                        next.addLast(node.right);
                    }
                }
            }

            current.clear();
            current.addAll(next);
            next.clear();
        }

        return root;
    }

    @SuppressWarnings("unused")
    public static boolean stackOverFlow(int deep) {
        return Thread.currentThread().getStackTrace().length > deep;
    }

    public static void mock(String input) {
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);
    }

    public static void measureTimeMillis(Runnable block) {
        long start = System.currentTimeMillis();
        block.run();
        long end = System.currentTimeMillis();
        String builder = "????????????: " + ((end - start) / 1000.0) + "???";
        System.out.println(builder);
    }

    private static int[] parseIntArray(String text) {
        final StringBuilder buff = new StringBuilder();
        final List<Integer> linked = new LinkedList<>();
        for (int i = 1; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ',' || ch == ']') {
                linked.add(Integer.parseInt(buff.toString()));
                buff.setLength(0);
            } else {
                buff.append(ch);
            }
        }

        final int[] array = new int[linked.size()];
        int pos = 0;
        for (Integer integer : linked) {
            array[pos++] = integer;
        }

        return array;
    }

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

}
