package threading;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {
    private static volatile boolean stop = false;
    public static void run() {
        new Thread(
                () -> {
                    while (!stop) {
                        System.out.printf("Thread %s Running!!\n",Thread.currentThread().getName());
                    }
                }
        ).start();

        System.out.printf("%s thread is Running!!!!!!!\n",Thread.currentThread().getName());
        sleep(100);
        stop = true;
    }
    private   static void sleep(int timeInSecond) {
        //Thread.sleep(10000);
        try {
            TimeUnit.MILLISECONDS.sleep(timeInSecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
