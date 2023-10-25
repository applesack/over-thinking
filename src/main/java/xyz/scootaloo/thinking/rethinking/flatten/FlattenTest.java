package xyz.scootaloo.thinking.rethinking.flatten;

/**
 * @author AppleSack
 * @since 2023/10/24
 */
public class FlattenTest {

    public static void main(String[] args) {
        var flatten = Flatten.builder("C:\\Users\\23839\\Documents\\Tencent Files\\2383955734\\Image\\Group2")
                .command("count", "")
                .command("get-ext", "")
                .command("ext", "jpg,JPG,bmp,gif,png,PNG,jpeg,heif,who")
                .command("copy", "D:\\temp\\test")
                .build();
        flatten.start();
    }

}
