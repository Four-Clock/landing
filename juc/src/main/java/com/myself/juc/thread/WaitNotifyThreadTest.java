package com.myself.juc.thread;

import com.myself.logger.LoggerUtil;

/**
 * 功能描述: WaitNotifyThreadTest
 * 1:线程一先拿到锁，然后睡眠，进入到等待队列，此时锁未释放
 * 2:线程二尝试拿锁，但未拿到，进入到同步队列。
 * 3:等到线程一执行完后，线程二拿到锁从阻塞状态进到就绪状态，等待CPU调度
 * 4:主线程执行完毕
 * ----------------------------------------------------
 * 1:线程一拿到锁后，调用wait方法，释放锁，并进入到等待队列
 * 2:此时线程二拿到锁，执行业务方法后，调用notify方法，释放锁，唤醒线程一，此时线程一处于就绪状态，等待CPU调度
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
public class WaitNotifyThreadTest {

    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread r1 = new Thread(()->{
            synchronized (lock){
                try {
                    lock.wait();
                    Thread.sleep(5000);
                    LoggerUtil.info("thread "+ Thread.currentThread().getName()+" started");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        r1.setName("r1");
        r1.start();

        Thread r2 = new Thread(()->{
            synchronized (lock){
                LoggerUtil.info("thread "+ Thread.currentThread().getName()+" started");
                lock.notify();
            }
        });
        r2.setName("r2");
        r2.start();
        LoggerUtil.info("main thread exit...........");
    }
}
