package threads.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SingleExecutors {
    private static final int corePoolSize = Runtime.getRuntime().availableProcessors();

    private SingleExecutors(){}
    private static class Assistant{
        private static final ThreadPoolExecutor singleExecutors =
                new ExecutorsUtil(corePoolSize,2*corePoolSize,0, TimeUnit.SECONDS,new LinkedBlockingDeque(),"");
    }

    public static ThreadPoolExecutor getSingleExecutors(){
        return Assistant.singleExecutors;
    }

    public static void main(String[] args) {
        SingleExecutors.getSingleExecutors().submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("=-==========");
            }
        });
    }
}
