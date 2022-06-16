package foundation.thread;

import java.util.concurrent.locks.StampedLock;

//import jdk.internal.misc.Unsafe;

public class MyStampedLock {
	public static void main(String[] args) {
		StampedLock stampedLock = new StampedLock();
		stampedLock.tryReadLock();
//		Unsafe.getUnsafe();
		long st = 1L;
		long st1 = 3L;
		// 1 01
		// 3 11
		System.out.println(st | st1);
		System.out.println(st & st1);
		System.out.println(~st1);
		System.out.println(1 << 7);
		System.out.println(128 >> 10);
		System.out.println(128 >>> 7);
	}
}
