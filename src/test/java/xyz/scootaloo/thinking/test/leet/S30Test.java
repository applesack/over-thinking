package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S30;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
public class S30Test {

    private final S30 solution = new S30();

    @Test
    public void test() {
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
        System.out.println(solution.findSubstring(
                "wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }));
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman",
                new String[] { "bar", "foo", "the" }));
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword",
                new String[] { "word", "good", "best", "good" }));
        System.out.println(solution.findSubstring("ababababab",
                new String[] { "ababa", "babab" }));
    }

    @Test
    public void test1() {
        System.out.println(solution.findSubstring(
                "wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }));
    }

    @Test
    public void test2() {
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman",
                new String[] { "bar", "foo", "the" }));
    }

    @Test
    public void test3() {
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword",
                new String[] { "word", "good", "best", "good" }));
    }

    @Test
    public void test4() {
        System.out.println(solution.findSubstring("ababababab",
                new String[] { "ababa", "babab" }));
    }

}
