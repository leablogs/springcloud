package threads.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                try {
                    System.out.println("有 " + atomicInteger.incrementAndGet() + "个线程处于阻塞状态");
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName() + "发起并发请求");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Thread" + i).start();
            TimeUnit.SECONDS.sleep(1);

        }
    }
}






















