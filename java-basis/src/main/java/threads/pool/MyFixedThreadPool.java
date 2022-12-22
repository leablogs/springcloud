package threads.pool;import lombok.extern.slf4j.Slf4j;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import java.io.BufferedWriter;import java.io.File;import java.io.FileWriter;import java.io.IOException;import java.util.concurrent.*;import java.util.concurrent.atomic.AtomicInteger;public class MyFixedThreadPool {    private String poolName;    private int corePoolSize = Runtime.getRuntime().availableProcessors();    private Runnable runnable;    private ThreadFactory threadFactory;    private static BlockingQueue workQueue;    private RejectedExecutionHandler abortPolicyReject;    private final static Logger log = LoggerFactory.getLogger(MyFixedThreadPool.class);    MyFixedThreadPool(String poolName) {        this.poolName = poolName;        threadFactory = new ExecutorThreadFactory(poolName);        abortPolicyReject = new AbortPolicyReject(poolName);        workQueue = new LinkedBlockingDeque(Integer.MAX_VALUE);    }    public ThreadPoolExecutor threadPoolExecutor() throws InstantiationException, IllegalAccessException {        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, 2 * corePoolSize, 10, TimeUnit.SECONDS, workQueue, threadFactory, abortPolicyReject);//        threadPoolExecutor.allowCoreThreadTimeOut(true);        threadPoolExecutor.prestartCoreThread();        log.info("启动所有核心线程返回线程启动数量：{}个", threadPoolExecutor.prestartAllCoreThreads());        log.info("获取拒绝策略：{}", threadPoolExecutor.getRejectedExecutionHandler());        log.info("获取线程工厂：{}", threadPoolExecutor.getThreadFactory());        return threadPoolExecutor;    }    class ExecutorThreadFactory implements ThreadFactory {        private Runnable runnable;        private final String poolName;        private final AtomicInteger threadNum = new AtomicInteger(1);        ExecutorThreadFactory(String poolName) {            this.poolName = poolName;        }        @Override        public Thread newThread(Runnable r) {            log.info("pool name:{}", this.poolName);            Thread t = new Thread(r, poolName + threadNum.getAndIncrement());            if (t.isDaemon()) {                t.setDaemon(true);            }            if (t.getPriority() != Thread.NORM_PRIORITY) {                t.setPriority(Thread.NORM_PRIORITY);            }            return t;        }    }    class AbortPolicyReject extends ThreadPoolExecutor.AbortPolicy {        private final String poolName;        AbortPolicyReject(String poolName) {            log.info("队列已满，采取忽略策略");            this.poolName = poolName;        }        @Override        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {            String msg = String.format("Provider端线程池满!" +                            " Thread Name: %s, Pool Size: %d (active: %d, core: %d, max: %d, largest: %d), Task: %d (completed: %d)," +                            " Executor status:(isShutdown:%s, isTerminated:%s, isTerminating:%s)",                    poolName, e.getPoolSize(), e.getActiveCount(), e.getCorePoolSize(), e.getMaximumPoolSize(), e.getLargestPoolSize(),                    e.getTaskCount(), e.getCompletedTaskCount(), e.isShutdown(), e.isTerminated(), e.isTerminating());            System.out.println(msg);//            super.rejectedExecution(r, e);            if (!e.isShutdown()) {                try {                    System.out.println("start get queue");                    e.getQueue().put(r);                    System.out.println("end get queue");                } catch (InterruptedException ex) {                    ex.printStackTrace();                }            }        }    }    public void aaa() {    }    class MyFuture implements RunnableFuture {        @Override        public void run() {        }        @Override        public boolean cancel(boolean mayInterruptIfRunning) {            return false;        }        @Override        public boolean isCancelled() {            return false;        }        @Override        public boolean isDone() {            return false;        }        @Override        public Object get() throws InterruptedException, ExecutionException {            return null;        }        @Override        public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {            return null;        }    }}