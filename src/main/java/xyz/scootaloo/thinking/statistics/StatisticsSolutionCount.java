package xyz.scootaloo.thinking.statistics;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * BIO version
 *
 * @author AppleSack
 * @since 2023/02/18
 */
public class StatisticsSolutionCount {

    public static void main(String[] args) {
        // 统计区间 leet 包下的文件数量
        Path projectPath = Paths.get("").toAbsolutePath();
        println(projectPath.toString());
        Path solutionPath = Path.of(projectPath.toString(), "src/main/java/xyz/scootaloo/thinking/leet");
        File file = solutionPath.toFile();
        if (!file.exists()) {
            println("solution dir not found");
            return;
        }
        if (!file.isDirectory()) {
            println("solution path not a directory");
            return;
        }
        println(String.format("found %d solution", Objects.requireNonNull(file.list()).length));
    }

    private static void println(Object any) {
        System.out.println(any);
    }

}
