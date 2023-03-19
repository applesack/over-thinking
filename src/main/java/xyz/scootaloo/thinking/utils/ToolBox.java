package xyz.scootaloo.thinking.utils;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;
import xyz.scootaloo.thinking.leet.ds.ListNode;
import xyz.scootaloo.thinking.leet.ds.TreeNode;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/06 - 20:17
 */
public class ToolBox {

    public static final String[] EMPTY_ARG = {};

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

    public static ListNode link(int... nums) {
        ListNode vHead = new ListNode(0);
        ListNode p = vHead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return vHead.next;
    }

    public static void printList(ListNode p) {
        StringBuilder buff = new StringBuilder();
        for (; p != null; p = p.next) {
            buff.append(p.val);
            buff.append(" -> ");
        }
        buff.append("null");
        System.out.println(buff);
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
        String builder = "执行用时: " + ((end - start) / 1000.0) + "秒";
        System.out.println(builder);
    }

    public static char[][] parse2dCharArray(String text) {
        List<List<String>> lines = parse2dStringList(text);
        int row = lines.size(), column = lines.get(0).size();
        char[][] chars = new char[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                String item = lines.get(r).get(c);
                chars[r][c] = item.charAt(0);
            }
        }
        return chars;
    }

    public static List<List<String>> parse2dStringList(String text) {
        int idx1, idx2;
        idx2 = text.indexOf('[') + 1;
        List<List<String>> result = new LinkedList<>();
        while (true) {
            idx1 = text.indexOf('[', idx2);
            if (idx1 < 0) {
                break;
            }
            idx2 = text.indexOf( ']', idx1);
            if (idx2 < 0) {
                break;
            }
            String sub = text.substring(idx1 + 1, idx2);
            String[] items = sub.split(",");
            result.add(Arrays.stream(items)
                    .map(s -> s.replace('\"', ' '))
                    .map(s -> s.replace(" ", ""))
                    .collect(Collectors.toList()));
        }
        return result;
    }

    public static int[][] parse2dIntArray(String text) {
        List<List<Integer>> container = new LinkedList<>();
        List<Integer> local = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        int len = text.length();
        int i = 0;
        while (text.charAt(i) != '[') i++;
        for (; i < len; i++) {
            char ch = text.charAt(i);
            if (ch == '[') {
                local.clear();
            }
            if ((ch == '-' || ch == '+') || (ch >= '0' && ch <= '9')) {
                builder.append(ch);
            } else if (ch == ',' || ch == ']') {
                if (builder.length() > 0) {
                    local.add(Integer.valueOf(builder.toString()));
                    builder.setLength(0);
                }
                if (text.charAt(i - 1) == ']') {
                    container.add(new ArrayList<>(local));
                }
            }
        }

        int row = container.size();
        int[][] arr2d = new int[row][];
        for (i = 0; i < row; i++) {
            arr2d[i] = container.get(i).stream().mapToInt(n -> n).toArray();
        }
        return arr2d;
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
