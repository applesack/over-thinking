package xyz.scootaloo.thinking.test.rethinking;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thking.rethinking.json.JsonCodec;

/**
 * @author AppleSack
 * @since 2023/05/02
 */
public class JsonParseTest {

    private static final JsonCodec codec = JsonCodec.INSTANCE;

    @Test
    public void test1() {
        System.out.println(codec.formString("123"));
        System.out.println(codec.formString("true"));
        System.out.println(codec.formString("false"));
        System.out.println(codec.formString("null"));
    }

    @Test
    public void test2() {
        System.out.println(codec.formString("[123, true,  null, false]"));
        System.out.println(codec.formString(" [\n \n123, \ttrue , \n null\n , \nfalse\n ]"));
        System.out.println(codec.formString("""
                \t [ "\\u0034906-", -6753.0e+9, false ]
                """));
    }

    @Test
    public void test3() {
        System.out.println(codec.formString("{\"abc\" : 789}"));
        System.out.println(codec.formString("""
                {
                "abc" : [123, "897", null, true]
                }
                """));
    }

    @Test
    public void test4() {
        System.out.println(codec.formString("""
                {
                "abc": 908,
                "def"    : null,
                "xyz": [124, {}, true , [990]
                ]
                }
                """));
    }

    @Test
    public void test5() {
        System.out.println(codec.formString("[]"));
        System.out.println(codec.formString("""
                [  "\\u007899\\"\\b",{},+12.90e3  ]
                """));
        System.out.println(codec.formString("[  null ]"));
        System.out.println(codec.formString("[  [[[[[[{},{}],{}],null, 9090],null]]]  ]"));
    }

    @Test
    public void test6() {
        runCatching(() -> codec.formString("["));
        runCatching(() -> codec.formString("""
                "hello world" 1299
                """));
        runCatching(() -> codec.formString("""
                {
                "abc": "9090",
                "def": "9090".,
                }
                """));
        runCatching(() -> codec.formString("1212a"));
        runCatching(() -> codec.formString("\n{\"12\":[true 1]}"));
        runCatching(() -> codec.formString("\n{12\":[true 1]}"));
        runCatching(() -> codec.formString("""
                {
                "abc": 908,
                "def"    : null,
                    "xyz": [124, {, true , [990]
                ]
                }
                """));
    }

    @Test
    public void test7() {
        runCatching(() -> System.out.println(codec.formString("""
            "\\"  \\u0069"
            """)));
    }

    private void runCatching(Runnable block) {
        try {
            block.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
