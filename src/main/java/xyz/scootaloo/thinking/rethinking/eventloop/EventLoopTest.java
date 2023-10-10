package xyz.scootaloo.thinking.rethinking.eventloop;

/**
 * @author AppleSack
 * @since 2023/10/10
 */
public class EventLoopTest {

    public static void main(String[] args) {
        // 服务器: 接受注册事件处理器，循环处理事件，将队列头的事件交给对应的处理处理
        // 客户端: 注册事件处理器，主动发送事件

        EventLoop eventLoop = new EventLoop();
        new Thread(() -> {
            for (int n = 0; n<6; n++) {
                delay(1000);
                eventLoop.dispatch(new Event("tick", n));
            }
            eventLoop.dispatch(new Event("stop", null));
        }).start();
        new Thread(() -> {
            delay(2500);
            eventLoop.dispatch(new Event("hello", "beautiful world"));
            delay(800);
        }).start();
        eventLoop.dispatch(new Event("hello", "world"));
        eventLoop.dispatch(new Event("foo", "bar"));
        eventLoop
                .on("hello", s -> System.out.println("hello " + s))
                .on("tick", n -> System.out.println("tick #" + n))
                .on("stop", v -> eventLoop.stop())
                .run();
        System.out.println("Bye!");
    }

    private static void delay(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
