package threads.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MySemaphore {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(10);
        for (int index = 0; index < 50; index++) {
            final int number = index;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("线程id：" + Thread.currentThread().getId() + "线程name:" + Thread.currentThread().getName() + "Accessing:" + number);
                    Thread.sleep((long) (Math.random() * 6000));
                    semaphore.release();
                    System.out.println("剩下可以执行信号量：" + semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        TimeUnit.SECONDS.sleep(100);
        executorService.shutdown();
    }
}





















