package foundation.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCachedThreadPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool(new MyThreadPoolFactory("cachedThread"));
		for(int i = 0;i<20;i++) {
			System.out.println("cacheThreadPool");
			System.out.println(Thread.currentThread().getName());
		}
		
//		ExecutorService executorService2 = Executors.newFixedThreadPool();
		Executors.newScheduledThreadPool(0);
		Executors.newSingleThreadExecutor();
//		Future<>
		
	}
}
