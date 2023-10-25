package xyz.scootaloo.thinking.rethinking.flatten;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.file.FileProps;

/**
 * @author AppleSack
 * @since 2023/10/24
 */
public class Flatten extends AbstractVerticle {

    private static final Logger log = LoggerFactory.getLogger(Flatten.class);

    private final List<CommandHandler> handlers = new ArrayList<>();

    private final String basePath;

    private final Set<String> extFilters = new HashSet<>();

    private Flatten(String basePath, List<Command> commands) {
        this.basePath = basePath;
        registerCommandHandler(commands);
    }

    public void start() {
        var vertx = Vertx.vertx();
        vertx.deployVerticle(this);
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        vertx.eventBus().<String>consumer("process", message -> {
            var path = message.body();
            log.info("{}", path);
            var fs = vertx.fileSystem();
            fs.props(path).onSuccess(props -> processFileWithCommand(path, props));
        });
        vertx.eventBus().consumer("done", message -> {
            for (CommandHandler handler : handlers) {
                handler.done();
            }
        });

        vertx.executeBlocking(this::travelFileSystem)
                .onComplete(done -> vertx.eventBus().send("done", ""));
    }

    private void registerCommandHandler(List<Command> commands) {
        for (Command command : commands) {
            switch (command.command) {
                case "ext":
                    handlers.add(new ExtCommandHandler(this, command));
                    break;
                case "get-ext":
                    handlers.add(new CountCommandHandler(this));
                    break;
                case "copy":
                    handlers.add(new CopyCommandHandler(this, command));
                    break;
                case "count":
                    handlers.add(new GetExtCommandHandler(this));
                    break;
            }
        }
    }

    private void travelFileSystem(Promise<Void> promise) {
        Queue<String> queue = new LinkedList<>();
        queue.add(basePath);

        while (!queue.isEmpty()) {
            var head = queue.remove();
            var file = new File(head);
            try {
                if (file.isDirectory()) {
                    var subFiles = file.list();
                    if (subFiles != null) {
                        queue.addAll(Arrays.stream(subFiles)
                                .map(it -> head + File.separator + it)
                                .toList());
                    }
                } else {
                    if (getFileExt(head) != null) {
                        vertx.eventBus().send("process", head);
                    }
                }
            } catch (Throwable e) {
                handleTravelFailure(head, e);
            }
        }

        promise.complete();
    }

    private void processFileWithCommand(String path, FileProps props) {
        var fs = vertx.fileSystem();
        if (props.isDirectory()) {
            fs.readDir(path).onSuccess(files -> {
                var bus = vertx.eventBus();
                for (String file : files) {
                    bus.send("detect", file);
                }
            });
        } else {
            for (CommandHandler handler : handlers) {
                handler.handle(path, props);
            }
        }
    }

    private String getFileExt(String filename) {
        if (filename == null) {
            return null;
        }
        var idx = filename.lastIndexOf('.');
        if (idx < 0 || idx == filename.length() - 1) {
            return null;
        }
        return filename.substring(idx + 1);
    }

    private String getFileName(String filename) {
        var normalize = filename.replace('\\', '/');
        var idx = normalize.lastIndexOf('/');
        if (idx < 0 || idx == normalize.length() - 1) {
            return filename;
        }
        return normalize.substring(idx + 1);
    }

    private void handleTravelFailure(String path, Throwable throwable) {
        log.error("{}", path, throwable);
    }

    private record ExtCommandHandler(Flatten that, Command command) implements CommandHandler {
        private ExtCommandHandler {
            var extArr = command.arg.split(",");
            that.extFilters.addAll(Arrays.asList(extArr));
        }

        @Override
        public void handle(String file, FileProps props) {
        }

        @Override
        public void done() {
        }
    }

    private record CopyCommandHandler(Flatten that, Command command) implements CommandHandler {
        @Override
            public void handle(String file, FileProps props) {
                var destBase = command.arg;
                var fs = that.vertx.fileSystem();
                var ext = that.getFileExt(file);
                if (that.extFilters.contains(ext)) {
                    var dest = destBase + "/" + props.lastModifiedTime() + that.getFileName(file);
                    fs.copy(file, dest).onComplete(done -> {
                        if (done.succeeded()) {
                            log.info("copy from {} to {}, ok", file, dest);
                        } else {
                            log.error("copy from {} to {}, ok", file, dest, done.cause());
                        }
                    });
                }
            }

            @Override
            public void done() {
            }
        }

    private static final class CountCommandHandler implements CommandHandler {
        private final Flatten that;
        private       int     count;

        private CountCommandHandler(Flatten that) {
            this.that = that;
        }

        @Override
        public void handle(String file, FileProps props) {
            if (!that.extFilters.isEmpty()) {
                var ext = that.getFileExt(file);
                if (that.extFilters.contains(ext)) {
                    count++;
                }
            } else {
                count++;
            }
        }

        @Override
        public void done() {
            log.info("count command: file total " + count);
        }
    }

    private static final class GetExtCommandHandler implements CommandHandler {
        private final Flatten     that;
        private final Set<String> extSet = new HashSet<>();

        private GetExtCommandHandler(Flatten that) {
            this.that = that;
        }

        @Override
        public void handle(String file, FileProps props) {
            var ext = that.getFileExt(file);
            if (!that.extFilters.isEmpty()) {
                if (that.extFilters.contains(ext)) {
                    extSet.add(ext);
                }
            } else {
                extSet.add(ext);
            }
        }

        @Override
        public void done() {
            log.info("get-ext command: found ext [{}]", String.join(",", extSet));
        }
    }

    public static Builder builder(String basePath) {
        return new Builder(basePath);
    }

    public static class Builder {
        private final String        basePath;
        private final List<Command> commands = new ArrayList<>();

        public Builder(String basePath) {
            this.basePath = basePath;
        }

        public Builder command(String command, String arg) {
            commands.add(new Command(command, arg));
            return this;
        }

        public Flatten build() {
            return new Flatten(basePath, commands);
        }
    }

    private interface CommandHandler {
        void handle(String file, FileProps props);

        void done();
    }

    private record Command(String command, String arg) {
    }
}
