package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S6197;
import xyz.scootaloo.thinking.leet.S6212;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/01 - 23:48
 */
public class S6197Test {

    private final S6197 solution = new S6197();

    @Test
    public void test() {
        S6197.LUPrefix prefix = new S6197.LUPrefix(4);
        prefix.upload(3);
        System.out.println(prefix.longest());
        prefix.upload(1);
        System.out.println(prefix.longest());
        prefix.upload(2);
        System.out.println(prefix.longest());
    }

}
