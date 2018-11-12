package com.study.common.server.utils;

import jodd.util.ThreadUtil;
import org.joda.time.DateTime;

/**
 * @ClassName ThreadTest1
 * @Description TODO
 * @Author xinbang
 * @Date 2018/10/31 11:47
 * @Version 1.0
 **/

public class ThreadTest1 {

    private static int sleepTime = 1000;

    public static void task(int data) {
        while (true) {
            System.out.println(DateTime.now() + "  task running........" + data);
            System.out.println(Thread.currentThread().getName() + "--->" + 3 / data);
            ThreadUtil.sleep(sleepTime);
            data--;
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println(t.getName() + " thread exception.......");
                    ThreadUtil.sleep(sleepTime * 2);
                    System.out.println("thread start.......");
                    System.out.println(t.isAlive());
                    System.out.println(t.isInterrupted());
                    System.out.println(t.getState());

                    new Thread(new Task(), "testaa").start();
//                System.out.println(t.start());
                }
            });
            task(2);

        }
    }

    public static void main(String[] args) {
        Thread first = new Thread(new Task(), "testaa");
        first.start();
        ThreadUtil.sleep(4000);
        System.out.println("first alive1:" + first.isAlive());
        ThreadUtil.sleep(1000);
        System.out.println("first alive2:" + first.isAlive());
    }
}
