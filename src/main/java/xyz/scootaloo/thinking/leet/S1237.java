package xyz.scootaloo.thinking.leet;

import xyz.scootaloo.thinking.leet.ds.CustomFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
public class S1237 {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i<=z; i++) {
            for (int j = 1; j<=z; j++) {
                int result = customfunction.f(i, j);
                if (result == z) {
                    ans.add(help(i, j));
                }
            }
        }
        return ans;
    }

    private List<Integer> help(int x, int y) {
        List<Integer> list = new ArrayList<>(2);
        list.add(x);
        list.add(y);
        return list;
    }

}
