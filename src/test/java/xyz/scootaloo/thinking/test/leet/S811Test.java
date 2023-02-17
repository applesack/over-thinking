package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S811;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/05 - 10:39
 */
public class S811Test {

    private final S811 solution = new S811();

    @Test
    public void test() {
        String[] domains = {
                "9001 discuss.leetcode.com"
        };
        System.out.println(solution.subdomainVisits(domains));
    }

    @Test
    public void test2() {
        String[] domains = {
                "900 google.mail.com",
                "50 yahoo.com",
                "1 intel.mail.com",
                "5 wiki.org"
        };
        System.out.println(solution.subdomainVisits(domains));
    }

}
