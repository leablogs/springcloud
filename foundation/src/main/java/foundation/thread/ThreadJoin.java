package foundation.thread;

import cn.hutool.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadJoin {
    private static final Logger log = LoggerFactory.getLogger(ThreadJoin.class);
    public static void main(String[] args) throws InterruptedException {
        MyThreadA myThreadA = new MyThreadA();
        Thread thread = new Thread(myThreadA);
        Thread thread1 = new Thread(myThreadA);
        log.error("------------");
        log.debug("33333333333");
        log.info("-===========");
//        thread.start();
//        thread.join(100);
//        thread1.start();
//        Lock lock = new ReentrantLock();
//        lock.lock(
//        try{
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + i);
//        }
    }
}

class MyThreadA implements Runnable {
//    private int num;
//
//    public MyThreadA(int num) {
//        this.num = num;
//    }

    @Override
    public void run() {

        for (int j = 0; j < 30; j++) {
            System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName() + "-" + j);
        }
    }
}