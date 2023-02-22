package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S200;

/**
 * @author AppleSack
 * @since 2023/02/21
 */
public class S200Test {

    private final S200 solution = new S200();

    @Test
    public void test() {
        System.out.println(solution.numIslands(new char[][] {
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray()
        }));
        System.out.println(solution.numIslands(new char[][] {
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
        }));
    }

    @Test
    public void test1() {
        System.out.println(solution.numIslands(new char[][] {
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
        }));
    }

}
