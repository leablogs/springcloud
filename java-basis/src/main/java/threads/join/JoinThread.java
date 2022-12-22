package threads.join;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join(2000);
        System.out.println("我想当myThread执行完毕后执行");
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random()*1000);
            secondValue = 5000;
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}