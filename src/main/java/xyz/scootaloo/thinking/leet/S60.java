package xyz.scootaloo.thinking.leet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author AppleSack
 * @since 2023/03/31
 */
public class S60 {

    /*
        n的排列顺序可以分为n组
        每一组有(n-1)!种排列
        1 2 3 | 1
        1 3 2 | 2
        2 1 3 | 3
        2 3 1 | 4
        3 1 2 | 5
        3 2 1 | 6
     */

    public String getPermutation(int n, int k) {
        return getPermutation(IntStream.range(1, n + 1)
                .boxed()
                .collect(Collectors.toList()), k - 1);
    }

    private String getPermutation(List<Integer> numbers, int k) {
        if (numbers.size() == 1) {
            return String.valueOf(numbers.get(0));
        }
        int size = numbers.size();
        int part = getCount(size - 1);
        int del = numbers.remove(k / part);
        return del + getPermutation(numbers, k - (part * (k / part)));
    }

    private final Map<Integer, Integer> countMap = new HashMap<>();

    private int getCount(int count) {
        if (countMap.containsKey(count)) {
            return countMap.get(count);
        }
        if (count == 1) {
            return 1;
        }
        int rsl = count * getCount(count - 1);
        countMap.put(count, rsl);
        return rsl;
    }

}
