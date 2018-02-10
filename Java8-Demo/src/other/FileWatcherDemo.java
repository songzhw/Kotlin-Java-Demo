package other;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.StandardWatchEventKinds;

public class FileWatcherDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("temp.txt"); //与src平级
        if (!file.exists()) {
            file.createNewFile();
        }

        //        Path path = Paths.get("~/code/mine/Kotlin-Java-Mine/JavaTest");
        Path path = Paths.get("/Users/Song/code/mine/Kotlin-Java-Mine/JavaTest");
        WatchService watcher = FileSystems.getDefault().newWatchService();
        path.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);

        new Thread(() -> {
            try {
                while (true) {
                    WatchKey key = watcher.take();
                    for (WatchEvent<?> event : key.pollEvents()) {
                        if (event.kind() == StandardWatchEventKinds.OVERFLOW) {
                            //事件可能lost or discarded
                            continue;
                        }
                        Path fileName = (Path)event.context();
                        System.out.println("文件更新: " + fileName);
                    }
                    if (!key.reset()) { // 重设WatchKey
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }).start();
    }
}

