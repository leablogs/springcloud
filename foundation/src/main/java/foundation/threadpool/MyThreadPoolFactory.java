package foundation.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPoolFactory implements ThreadFactory {
	private AtomicInteger atomicInteger = new AtomicInteger(0);
	private String threadNamePrefix;
	MyThreadPoolFactory(String prefix){
		this.threadNamePrefix = prefix;
	}
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName(threadNamePrefix + "--xxjob"+atomicInteger.getAndIncrement());
		return thread;
	}
	public static void main(String[] args) {
		MyThreadPoolFactory myThreadPoolFactory = new MyThreadPoolFactory("shi");
		
		myThreadPoolFactory.newThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("aaaaaaaaaa");
			}
		});
	}
}
