package foundation.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyCachedThreadPool {
	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newCachedThreadPool(new MyThreadPoolFactory("cachedThread"));
//		for(int i = 0;i<20;i++) {
//			System.out.println("cacheThreadPool");
//			System.out.println(Thread.currentThread().getName());
//		}

//		ExecutorService executorService2 = Executors.newFixedThreadPool();
//		int corePoolSize, ThreadFactory threadFactory
//		ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5,
//				new MyThreadPoolFactory("scheduledThreadPool"));
//		for (int i = 0; i < 10; i++) {
//			System.out.println("scheduled thread pool");
//			System.out.println(Thread.currentThread().getId());
//		}
		System.out.println(Integer.MAX_VALUE);
//		Executors.newSingleThreadExecutor();
//		Future<>
//		int corePoolSize,
//        int maximumPoolSize,
//        long keepAliveTime,
//        TimeUnit unit,
//        BlockingQueue<Runnable> workQueue
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 30L, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(15));
		for (int i = 0; i < 10; i++) {
			executor.execute(() -> {
				System.out.println(Thread.currentThread().getName());
			});
		}
	}
}
