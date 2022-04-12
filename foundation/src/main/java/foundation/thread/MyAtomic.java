package foundation.thread;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;

import jdk.internal.misc.Unsafe;

public class MyAtomic {
	private final static Logger LOGGER = Logger.getLogger(MyAtomic.class);
	private static AtomicInteger atomicInteger = new AtomicInteger(10);

	public static void main(String[] args) throws InterruptedException {
//		jdk.internal.misc.Unsafe unsafe = jdk.internal.misc.Unsafe.getUnsafe();
//		unsafe.allocateMemory(30);
		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
		readWriteLock.isFair();
		ReentrantLock reentrantLock = new ReentrantLock();
//		reentrantLock
		reentrantLock.tryLock();
		System.out.println(reentrantLock.isFair());
//		LockSupport.park();
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				LockSupport.park();
				System.out.println("========================");
			}
		});
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				LockSupport.park();
				// TODO Auto-generated method stub
				System.out.println("888888888888888888888888888");
			}
		});
		thread.start();

		thread2.start();
		thread.sleep(3000);
		thread2.sleep(3000);
//		LockSupport.unpark(thread2);
//		LockSupport.unpark(thread);
//		LockSupport.unpark(null);
//		atomicInteger.set(12);
//		atomicInteger.getAndAdd(3);
//		atomicInteger.compareAndSet(12, 20);
//		System.out.println(atomicInteger);
	}

	public static AtomicInteger getAtomicInteger() {
		return atomicInteger;
	}

	public static void setAtomicInteger(AtomicInteger atomicInteger) {
		MyAtomic.atomicInteger = atomicInteger;
	}
}
