package xyz.scootaloo.thinking.statistics;

import kotlin.NotImplementedError;

import java.io.File;
import java.nio.file.Paths;

/**
 * @author AppleSack
 * @since 2023/02/18
 */
public class Statistics {

    private final File projectRoot;
    private       File currentWorkDir;

    private Statistics() {
        projectRoot = Paths.get("").toFile();
        if (!projectRoot.isDirectory()) {
            throw new IllegalStateException("project not a dir");
        }

        currentWorkDir = projectRoot;
    }

    public boolean location(String path) {
        throw new NotImplementedError();
    }

    public void walkFS(File root) {
    }

}
