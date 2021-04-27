package com.myself.juc.thread;

import com.myself.logger.LoggerUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * 功能描述: ParkUnParkTest
 *  LockSupport.park():将当前线程挂起，进入到等待队列 (RUNNABLE->WAITING)
 *  LockSupport.unpark(r1):唤醒指定线程 (WAITING->RUNNABLE)
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
public class ParkUnParkTest {

    public static void main(String[] args) {
        Thread r1 = new Thread(()->{
            LockSupport.park();
            LoggerUtil.info("thread "+ Thread.currentThread().getName()+" started");
        });
        r1.setName("r1");
        r1.start();

        Thread r2 = new Thread(()->{
            try {
                Thread.sleep(1000);
                LoggerUtil.info("thread "+ Thread.currentThread().getName()+" started");
                LockSupport.unpark(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        r2.setName("r2");
        r2.start();
        LoggerUtil.info("main thread exit...........");
    }


}
