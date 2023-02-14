package xyz.scootaloo.thinking.leet;

import java.util.LinkedList;
import java.util.List;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/15 - 8:21
 */
@SuppressWarnings("unused")
public class S1441 {

    public List<String> buildArray(int[] target, int n) {
        LinkedList<String> ans = new LinkedList<>();
        int cur = 0;
        for (int num : target) {
            for (int i = 0; i < num - cur - 1; i++) {
                ans.add("Push");
                ans.add("Pop");
            }
            cur = num;
            ans.add("Push");
        }
        return ans;
    }

}
