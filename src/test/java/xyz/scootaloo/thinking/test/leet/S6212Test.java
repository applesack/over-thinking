package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S6212;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/01 - 22:43
 */
public class S6212Test {

    private final S6212 solution = new S6212();

    @Test
    public void test() {
        System.out.println(solution.equalFrequency("abcc"));        // true
        System.out.println(solution.equalFrequency("aacc"));        // false
        System.out.println(solution.equalFrequency("cbc"));         // true
        System.out.println(solution.equalFrequency("abbbbbccccc")); // true
        System.out.println(solution.equalFrequency("cbccac"));      // false
        System.out.println(solution.equalFrequency("ddaccb"));      // false
        System.out.println(solution.equalFrequency("ddbbccc"));     // true
    }

}
