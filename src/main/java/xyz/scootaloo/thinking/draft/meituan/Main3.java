package xyz.scootaloo.thinking.draft.meituan;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 假设你现在是一个指挥官，你要把 n+1 个士兵排成一列。这些士兵标号从0到n。初始时，0号士兵站在列队中，之后第1,2,3,...,n 号士兵依次插入列队中。你可以对每个士兵下达一次命令，即第 i 个士兵是插入进第i-1个士兵的左侧（L）还是右侧（R）。剩下n个士兵执行完命令之后，你想知道这个列队最后的样子。
 * <p>
 * 由于输出可能会很多，本题按照如下格式输出：设ai表示第 i 个位置的士兵标号，则输出一个整
 *
 * @author flutterdash@qq.com
 * @since 2022/10/08 - 10:47
 */
public class Main3 {

    //
    //   0 1 2 3 4 5
    // L 1 0
    // R 1 2 0
    // R 1 2 3 0
    // L 1 2 4 3 0
    // R 1 2 4 5 3 0
    // 2 6
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String line = scanner.next();
        LinkedList<Integer> linked = new LinkedList<>();
        linked.add(0);
        int last = 0;
        for (int i = 1; i <= n; i++) {
            if (i < line.length() + 1) {
                char ch = line.charAt(i - 1);
                if (ch == 'L') {
                    linked.add(last, i);
                } else {
                    if (last + 1 >= linked.size()) {
                        linked.add(i);
                        last = linked.size() - 1;
                    } else {
                        linked.add(last + 1, i);
                        last = last + 1;
                    }
                }
            } else {
                linked.add(i);
            }
        }

        int sum = -1;
        int idx = 1;
        for (Integer num : linked) {
            // 01
            // 11
            if (sum == -1) {
                sum = (idx * num + idx);
            } else {
                sum ^= (idx * num + idx);
            }
            idx++;
        }

        // 2 ^ 6 ^ 15 ^ 24 ^ 20 ^ 6
        System.out.println(sum);
    }

}
