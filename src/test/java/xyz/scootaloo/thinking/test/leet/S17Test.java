package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S17;

/**
 * @author AppleSack
 * @since 2023/02/26
 */
public class S17Test {

    private final S17 solution = new S17();

    @Test
    public void test() {
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations(""));
    }

}
