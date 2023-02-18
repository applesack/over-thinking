package xyz.scootaloo.thinking.test.draft;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.draft.onlinetesting.MainSolution;

/**
 * @author flutterdash@qq.com
 * @since 2022/11/10 - 11:05
 */
public class MainSolutionTest {

    private final MainSolution solution = new MainSolution();

    @Test
    public void test1() {
        display("1.1", "ab&&2", solution.stringSplit("ab&&2"));
        display("1.1", "&&2", solution.stringSplit("&&2"));
        display("1.1", "2&&", solution.stringSplit("2&&"));
        display("1.1", "2&2&&2&&&", solution.stringSplit("2&2&&2&&&"));
        separator();
        display("1.2", "[aa, bb]", solution.stringJoint("&&", "aa", "bb"));
        display("1.2", "[aa]", solution.stringJoint("&&", "aa"));
        separator();
        display("2", 2, solution.findPrimeNumber(2));
        display("2", 100, solution.findPrimeNumber(100));
        display("2", 100, solution.findPrimeNumber(96));
        separator();
        display("3", "[0, 1, 2, 1]", solution.findDuplicateNumber(new int[] {0, 1, 2, 1}));
        display("3", "[0, 1, 2, 2]", solution.findDuplicateNumber(new int[] {0, 1, 2, 2}));
        separator();
        display("4", "n=3, m=4", solution.findSurvivor(3, 4));
        separator();
        display("5", "[a, b, c]", solution.fullPermutation('a', 'b', 'c'));
    }

    private void display(String number, Object input, Object output) {
        System.out.println(number + ": input[" + input + "] => " + output);
    }

    private void separator() {
        System.out.println("------------------------------");
    }

}
