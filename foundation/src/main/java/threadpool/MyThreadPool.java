package threadpool;

import cn.hutool.core.thread.NamedThreadFactory;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPool {
    public static void main(String[] args) throws IOException {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService2 = Executors.newCachedThreadPool();
//        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
        int corePoolSize = 3;
        int maximumPoolSize = 5;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(15);
        ThreadFactory threadFactory = new NamedThreadFactory();
        RejectedExecutionHandler rejectedExecutionHandler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, unit, workQueue, threadFactory, rejectedExecutionHandler);
        executor.prestartAllCoreThreads();
        for (int i = 1; i <= 100; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            executor.execute(task);
        }
        System.in.read();
    }

    static class NamedThreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);




        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, "my thread" + mThreadNum.getAndIncrement());
            System.out.println(thread.getName() + " had beann created");
            return thread;
        }
    }

    static class MyIgnorePolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            dLog(r, executor);
        }

        private void dLog(Runnable r, ThreadPoolExecutor executor) {
            System.err.println(r.toString() + " rejected");
        }
    }

    static class MyTask implements Runnable {
        private String name;

        MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return "My task [name= " + name + "]";
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running, thread id: " + Thread.currentThread().getId());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


























