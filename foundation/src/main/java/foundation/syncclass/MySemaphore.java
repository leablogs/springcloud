package foundation.syncclass;

import java.util.concurrent.Semaphore;

public class MySemaphore {
	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(10, true);
		semaphore.acquire();
		semaphore.release();
		Object aaObject = new Object();
		aaObject.wait();
	}
}
