package xyz.scootaloo.thinking.test.leet;

import org.junit.jupiter.api.Test;
import xyz.scootaloo.thinking.leet.S65;

/**
 * @author AppleSack
 * @since 2023/03/11
 */
public class S65Test {

    private final S65 solution = new S65();

    @Test
    public void test() {
        testMustPass();
        testMustFail();
    }

    @Test
    public void testMustPass() {
        if (!solution.isNumber("2")) throw new AssertionError();
        if (!solution.isNumber("0089")) throw new AssertionError();
        if (!solution.isNumber("-0.1")) throw new AssertionError();
        if (!solution.isNumber("+3.14")) throw new AssertionError();
        if (!solution.isNumber("4.")) throw new AssertionError();
        if (!solution.isNumber("-.9")) throw new AssertionError();
        if (!solution.isNumber("-90E3")) throw new AssertionError();
        if (!solution.isNumber("3e+7")) throw new AssertionError();
        if (!solution.isNumber("+6e-1")) throw new AssertionError();
        if (!solution.isNumber("53.5e93")) throw new AssertionError();
        if (!solution.isNumber("-123.456e789")) throw new AssertionError();
        if (!solution.isNumber("46.e3")) throw new AssertionError();
    }

    @Test
    public void testMustFail() {
        if (solution.isNumber("abc")) throw new AssertionError();
        if (solution.isNumber("1a")) throw new AssertionError();
        if (solution.isNumber("1e")) throw new AssertionError();
        if (solution.isNumber("99e2.5")) throw new AssertionError();
        if (solution.isNumber("--6")) throw new AssertionError();
        if (solution.isNumber("-+3")) throw new AssertionError();
        if (solution.isNumber("95a54e53")) throw new AssertionError();
        if (solution.isNumber(".")) throw new AssertionError();
        if (solution.isNumber(".e12")) throw new AssertionError();
        if (solution.isNumber("e9")) throw new AssertionError();
    }

}
