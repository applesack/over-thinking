package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S844;

/**
 * @author AppleSack
 * @since 2023/02/19
 */
public class S844Test {

    private final S844 solution = new S844();

    @Test
    public void test() {
        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
        System.out.println(solution.backspaceCompare("a#c", "b"));
    }

}
