package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S841;

import java.util.Arrays;
import java.util.List;

/**
 * @author AppleSack
 * @since 2023/03/16
 */
public class S841Test {

    private final S841 solution = new S841();

    @Test
    public void test() {
        System.out.println(solution.canVisitAllRooms(Arrays.asList(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        ))); // true

        System.out.println(solution.canVisitAllRooms(Arrays.asList(
                List.of(1, 3),
                List.of(3, 1, 0),
                List.of(2),
                List.of()
        ))); // false
    }

}
