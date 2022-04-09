package foundation.thread;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;

public class MyVolatile {
	public static void main(String[] args) {
		Write64 write64 = new Write64();
//		CountDownLatch countDownLatch = new CountDownLatch(2);
		for (int i = 0; i < 20; i++) {
			new Thread(new MyRunable(write64)).start();
			new Thread(new MyRunable1(write64)).start();
		}
//		Unsafe
		
//		countDownLatch.countDown();
	}

}

class MyRunable implements Runnable {
//	private CountDownLatch countDownLatch;
	private Write64 write64;

	public MyRunable(Write64 write64) {
//		public MyRunable(CountDownLatch countDownLatch, Write64 write64) {
//		this.countDownLatch = countDownLatch;
		this.write64 = write64;
	}

	@Override
	public void run() {
		System.out.println("=========================" + Calendar.getInstance().getTimeInMillis());
//			countDownLatch.wait();
		write64.setA(100);
	}
}

class MyRunable1 implements Runnable {
//	private CountDownLatch countDownLatch;
	private Write64 write64;

//	public MyRunable1(CountDownLatch countDownLatch, Write64 write64) {
	public MyRunable1(Write64 write64) {
//		this.countDownLatch = countDownLatch;
		this.write64 = write64;
	}

	@Override
	public void run() {
		System.out.println("-------------------------" + Calendar.getInstance().getTimeInMillis());
//			countDownLatch.wait();
		System.out.println(write64.getA());
	}
}

class Write64 {
//	private long a = 0;
	private volatile long a = 0;

	public long getA() {
		return a;
	}

	public void setA(long a) {
		this.a = a;
	}

}