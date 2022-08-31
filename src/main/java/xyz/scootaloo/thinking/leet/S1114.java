package xyz.scootaloo.thinking.leet;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/29 - 9:57
 */
public class S1114 {

    static class Foo {

        private final Object lock = new Object();
        private int state = 1;

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                while (state != 1) {
                    lock.wait();
                }
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                state = 2;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (state != 2) {
                    lock.wait();
                }

                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                state = 3;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (state != 3) {
                    lock.wait();
                }

                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                state = 1;
                lock.notifyAll();
            }
        }

    }

}
