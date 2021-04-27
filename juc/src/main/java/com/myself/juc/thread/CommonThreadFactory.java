package com.myself.juc.thread;

import com.myself.logger.LoggerUtil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述: ThreadFactory
 *  自定义通用线程池处理类
 * @author linqin.zxl
 * @date 2021/4/27
 */
public class CommonThreadFactory {

    private static final Integer MAX_CORE_SIEZ = Runtime.getRuntime().availableProcessors();

    private static final Integer MAX_POOL_SIZE = 16;

    private static final Integer KEEP_ALIVE_TIME = 5000;

    private static final BlockingQueue<Runnable> RUNNABLE_BLOCKING_QUEUE = new ArrayBlockingQueue<Runnable>(20);

    private static final String THREAD_PREFIX_NAME = "common_thread_";



    public static final ExecutorService COMMON_EXECUTOR_POOL = new ThreadPoolExecutor(MAX_CORE_SIEZ,MAX_POOL_SIZE,KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS
    ,RUNNABLE_BLOCKING_QUEUE,new ConsumerThreadFactory(THREAD_PREFIX_NAME),new ConsumerRejectedExecutionHandler());


    /**
     * 向线程池提交任务
     * @param r
     */
    public static void submitTask(Runnable r){
        COMMON_EXECUTOR_POOL.submit(r);
    }

    /**
     * 优雅停止线程池任务
     * 当线程池中所有任务执行完成后，线程池关闭
     */
    public static void suspend(){
        if (!COMMON_EXECUTOR_POOL.isShutdown()){
            COMMON_EXECUTOR_POOL.shutdown();
        }
    }


    private static class  ConsumerThreadFactory implements java.util.concurrent.ThreadFactory{

        private static AtomicInteger index = new AtomicInteger(0);

        private static ThreadGroup group;

        private String threadNamePrefix;

        public ConsumerThreadFactory(String threadNamePrefix) {
            this.threadNamePrefix = threadNamePrefix;
            SecurityManager sm = System.getSecurityManager();
            group = sm==null ? Thread.currentThread().getThreadGroup():sm.getThreadGroup();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(group,r,threadNamePrefix+index.getAndIncrement());
            if (thread.getPriority() != Thread.NORM_PRIORITY) {
                thread.setPriority(Thread.NORM_PRIORITY);
            }
            thread.setDaemon(true);
            return thread;
        }
    }

    private static class  ConsumerRejectedExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            LoggerUtil.warn("the thread is reject:"+executor.getActiveCount());
        }
    }
}
