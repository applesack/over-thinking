package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S68;

import java.util.List;

/**
 * @author AppleSack
 * @since 2023/03/11
 */
public class S68Test {

    private final S68 solution = new S68();

    @Test
    public void test() {
        print(solution.fullJustify(new String[] {
                "This", "is", "an", "example", "of", "text", "justification."
        }, 16));

        print(solution.fullJustify(new String[] {
                "What", "must", "be", "acknowledgment", "shall", "be"
        }, 16));

        print(solution.fullJustify(new String[] {
                "Science", "is", "what", "we", "understand", "well", "enough",
                "to", "explain", "to", "a", "computer.",
                "Art", "is", "everything", "else", "we", "do"
        }, 20));

        print(solution.fullJustify(new String[] {
                "ask", "not", "what", "your", "country",
                "can", "do", "for", "you", "ask", "what",
                "you", "can", "do", "for", "your", "country"
        }, 16));
    }

    private void print(List<String> lines) {
        for (String line : lines) {
            System.out.println(line + ";");
        }
        System.out.println();
    }

}
