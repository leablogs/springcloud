package threads.pool;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ThreadPoolTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        MyFixedThreadPool myFixedThreadPool = new MyFixedThreadPool("thread-1");
//        myFixedThreadPool.threadPoolExecutor().submit(new Runnable() {
//            @Override
//            public void run() {
//                log.info("-=-----------------");
//                try {
//                    log.info("获取线程池数量：{}", myFixedThreadPool.threadPoolExecutor().getPoolSize());
//                    log.info("获取核心线程池线程数量：{}", myFixedThreadPool.threadPoolExecutor().getCorePoolSize());
//                    log.info("获取任务队列的任务数量：{}", myFixedThreadPool.threadPoolExecutor().getQueue());
//                    log.info("获取处于活跃的线程数量：{}", myFixedThreadPool.threadPoolExecutor().getActiveCount());
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        System.out.println("int max: " + Integer.MAX_VALUE);
        System.out.println("Short max: " + Short.MAX_VALUE);
        System.out.println("Double max: " + Double.MAX_VALUE);
        System.out.println("Float max: " + Float.MAX_VALUE);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10, new ExecutorThreadFactory("newFixedThreadPool-my"));
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ExecutorThreadFactory("newSingleThreadExecutor-my"));
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new ExecutorThreadFactory("newCachedThreadPool-my"));
        MyFixedThreadPool myFixedThreadPool = new MyFixedThreadPool("Thread-PoolExecutor");
        ThreadPoolExecutor threadPoolExecutor = myFixedThreadPool.threadPoolExecutor();


        int size = 10000000;
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < size; i++) {
//            newFixedThreadPool.submit(new Runnable() {
//                @Override
//                public void run() {
////                    try {
////                        Thread.sleep(5);
////                    log.info("----------------------{}", Thread.currentThread().getName());
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
//                }
//            });
//        }
//        log.info("【newFixedThreadPool】总耗时：{}ms", System.currentTimeMillis() - start);
//        long start1 = System.currentTimeMillis();
//        for (int i = 0; i < size; i++) {
//            newSingleThreadExecutor.submit(new Runnable() {
//                @Override
//                public void run() {
////                    try {
////                        Thread.sleep(5);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    log.info("----------------------{}", Thread.currentThread().getName());
//                }
//            });
//        }
//        log.info("【newSingleThreadExecutor】总耗时：{}ms", System.currentTimeMillis() - start1);
//        long start2 = System.currentTimeMillis();
//        for (int i = 0; i < size; i++) {
//            newCachedThreadPool.submit(new Runnable() {
//                @Override
//                public void run() {
////                    try {
////                        Thread.sleep(5);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    log.info("----------------------{}", Thread.currentThread().getName());
//                }
//            });
//        }
//        log.info("【newCachedThreadPool】总耗时：{}ms", System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        log.info("----------------------{}", Thread.currentThread().getName());
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        log.info("【Thread Pool executors】总耗时：{}ms", System.currentTimeMillis() - start3);
    }

    static class ExecutorThreadFactory implements ThreadFactory {
        private Runnable runnable;
        private final String poolName;
        private final AtomicInteger threadNum = new AtomicInteger(1);

        ExecutorThreadFactory(String poolName) {
            this.poolName = poolName;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, poolName + threadNum.getAndIncrement());
            if (t.isDaemon()) {
                t.setDaemon(true);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }
}
