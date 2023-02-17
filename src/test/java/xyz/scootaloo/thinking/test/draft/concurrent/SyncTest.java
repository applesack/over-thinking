package xyz.scootaloo.thinking.test.draft.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class SyncTest {
    private static final AtomicInteger number = new AtomicInteger(0);

    private static final Runnable runable = () -> {
        final int repeat = 500;
        for (int i = 0; i<repeat; i++) {
            number.incrementAndGet();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            runable.run();
            cdl.countDown();
        });
        Thread t2 = new Thread(() -> {
            runable.run();
            cdl.countDown();
        });
        t1.start();
        t2.start();
        cdl.await();
        System.out.println(number.get());
    }

}