package ca.six.demo.lib.thread.reader_writer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ReaderWirterDemo {

    public static void main(String[] args) {
        Executor executors = Executors.newFixedThreadPool(4);
        executors.execute(new Reader());
        executors.execute(new Reader());
        executors.execute(new Writer());
        executors.execute(new Reader());
    }
}