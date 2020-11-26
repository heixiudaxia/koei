package onjava8.thread;

/**
 * @Author jojo
 * @create 2020/3/22 上午8:25
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<Integer> tl3 = new ThreadLocal<>();
    private static ThreadLocal<Integer> tl2 = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 100; i > 50; i--) {
                    tl3.set(i + 100);
                    tl2.set(i);
                    System.out.println(Thread.currentThread().getName() + "===" + tl2.get() + "+++" + tl3.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                tl2.remove();
                tl3.remove();
            }
        }, "THREAD_1").start();

        /*new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    threadLocal.set(i);
                    System.out.println(Thread.currentThread().getName() + "===" + threadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                threadLocal.remove();
            }
        }, "THREAD_2").start();*/
        System.err.println("等待执行完成");
    }
}
