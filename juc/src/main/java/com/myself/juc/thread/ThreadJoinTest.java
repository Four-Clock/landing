package com.myself.juc.thread;

import com.myself.logger.LoggerUtil;

/**
 * 功能描述: ThreadJoinTest
 *  thread.join 当前线程执行完毕后才会执行接下来的线程
 *  https://mp.weixin.qq.com/s/aG_uBLQevyZEFTOLK-kH9g
 * @author linqin.zxl
 * @date 2021/4/27
 */
public class ThreadJoinTest {

    public static void main(String[] args) {
        Thread r1 = new Thread(()->{
            LoggerUtil.info("thread "+ Thread.currentThread().getName()+" starting");
            try {
                Thread.sleep(5000);
                LoggerUtil.info("thread "+ Thread.currentThread().getName()+" ended");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        r1.setName("r1");
        r1.start();
        try {
            r1.join();
            LoggerUtil.info("this program is done................");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
