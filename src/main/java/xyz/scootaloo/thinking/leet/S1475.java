package xyz.scootaloo.thinking.leet;

import java.util.Stack;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/01 - 11:20
 */
public class S1475 {

    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] rsl = new int[len];
        if (len == 0) {
            return rsl;
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(prices[len - 1]);
        rsl[len - 1] = prices[len - 1];

        for (int i = len - 2; i>=0; i--) {
            if (prices[i] >= stack.peek()) {
                rsl[i] = prices[i] - stack.peek();
                stack.push(prices[i]);
            } else {
                rsl[i] = prices[i];
                while (!stack.isEmpty() && stack.peek() > prices[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() <= prices[i]) {
                    rsl[i] = prices[i] - stack.peek();
                }
                stack.push(prices[i]);
            }
        }

        return rsl;
    }

}
