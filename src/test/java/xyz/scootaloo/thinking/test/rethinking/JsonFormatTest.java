package xyz.scootaloo.thinking.test.rethinking;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thking.rethinking.json.Json;

/**
 * @author AppleSack
 * @since 2023/05/02
 */
public class JsonFormatTest {

    private static final Json json = Json.INSTANCE;

    @Test
    public void test1() {
        System.out.println(json.pretty("""
                {
                "abc": 908,
                "def"    : null,
                "xyz": [124, {},[[]], true , [990]
                ]
                }
                """, 2));
    }

    @Test
    public void test2() {
        System.out.println(json.pretty("""
                [123, 9077, [ 7 ] ,{"12":[]}]
                """, 2));
    }

}
