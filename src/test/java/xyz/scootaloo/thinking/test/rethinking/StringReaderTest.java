package xyz.scootaloo.thinking.test.rethinking;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author AppleSack
 * @since 2023/04/22
 */
public class StringReaderTest {

    @Test
    public void test() throws IOException {
        String text = "abcd";
        StringReader reader = new StringReader(text);
        StringBuilder builder = new StringBuilder();
        System.out.println(reader.read());
        System.out.println(reader.read());
        System.out.println(reader.read());
        System.out.println(reader.read());
        System.out.println(reader.read());
        reader.close();

        System.out.println(builder);
    }

}
