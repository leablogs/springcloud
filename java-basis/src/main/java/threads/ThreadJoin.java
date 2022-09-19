package threads;

import java.util.UUID;

public class ThreadJoin {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            myThread.join();
            System.out.println("等待子线程执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 10000);
            System.out.println("随机时间： " + secondValue);
            Thread.sleep(secondValue);
            Thread.interrupted();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}