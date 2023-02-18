package xyz.scootaloo.thinking.draft.onlinetesting.lang;

import java.lang.ref.SoftReference;

/**
 * @author AppleSack
 * @since 2023/02/14
 */
public class Lang1 {

    public static void main(String[] args) {
        Integer i = 1;
        System.out.println(Integer.valueOf(1));
        SoftReference<String> ref = new SoftReference<>("abc");
    }

}
