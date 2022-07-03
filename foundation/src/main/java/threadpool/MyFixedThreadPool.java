package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            executorService.execute(()->{

            });
            executorService.submit(()->{
                System.out.println("Thread id is: " + Thread.currentThread().getId());
                try {
                    Thread.sleep(1000L);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
    }
}
