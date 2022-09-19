package locks;

public class DieLock {
    public static void main(String[] args) {
        DealThread dealThread = new DealThread();
        dealThread.setFlag("a");
        Thread thread1 = new Thread(dealThread);
        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dealThread.setFlag("b");
        Thread thread2 = new Thread(dealThread);
        thread2.start();
    }
}
// 检测死锁 使用jps.exe 命令   查找运行的线程，之后执行jstack.exe 线程号查看线程锁信息
class DealThread extends Thread{
    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();
    public  void  setFlag (String username){
        this.username = username;
    }

    @Override
    public void run() {
        if(username.equals("a")){
            synchronized (lock1){
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("按 lock1->lock2 代码执行");
                }
            }
        }
        if(username.equals("b")){
            synchronized (lock2){
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("按 lock2->lock1 代码执行");
                }
            }
        }
    }
}






































