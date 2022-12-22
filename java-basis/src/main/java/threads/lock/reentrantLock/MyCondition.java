package threads.lock.reentrantLock;import java.util.concurrent.locks.Condition;import java.util.concurrent.locks.Lock;import java.util.concurrent.locks.ReentrantLock;public class MyCondition {    private Lock lock = new ReentrantLock();    public Condition condition = lock.newCondition();    public static void main(String[] args) throws InterruptedException {        MyCondition myCondition = new MyCondition();        ThreadA a = new ThreadA(myCondition);        a.setName("A");        a.start();        ThreadB b = new ThreadB(myCondition);        b.setName("B");        b.start();        Thread.sleep(3000);        myCondition.signalAll();    }    public void awaitA() {        try {            lock.lock();            System.out.println("begin awaitA 时间为:" + System.currentTimeMillis()                    + " Thread name=" + Thread.currentThread().getName());            condition.await();            System.out.println(" end awaitA时间为：" + System.currentTimeMillis()                    + " Thread name=" + Thread.currentThread().getName());//            condition.signal();        } catch (InterruptedException e) {            e.printStackTrace();        } finally {            lock.unlock();        }    }    public void awaitB() {        try {            lock.lock();            System.out.println("begin awaitB 时间为:" + System.currentTimeMillis()                    + " Thread name=" + Thread.currentThread().getName());            condition.await();            System.out.println(" end awaitB时间为：" + System.currentTimeMillis()                    + " Thread name=" + Thread.currentThread().getName());        } catch (InterruptedException e) {            e.printStackTrace();        } finally {            lock.unlock();        }    }    public void signalAll() {        try {            lock.lock();            System.out.println(" signaAll 时间为：" + System.currentTimeMillis()                    + "Thread name=" + Thread.currentThread().getName());        } finally {            lock.unlock();        }    }}class ThreadA extends Thread {    private MyCondition myCondition;    ThreadA(MyCondition myCondition) {        this.myCondition = myCondition;    }    @Override    public void run() {        myCondition.awaitA();    }}class ThreadB extends Thread {    private MyCondition myCondition;    ThreadB(MyCondition myCondition) {        this.myCondition = myCondition;    }    @Override    public void run() {        myCondition.awaitB();    }}