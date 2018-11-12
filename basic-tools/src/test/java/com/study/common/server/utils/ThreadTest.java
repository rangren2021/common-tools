package com.study.common.server.utils;

import jodd.util.ThreadUtil;
import org.joda.time.DateTime;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author xinbang
 * @Date 2018/10/31 10:49
 * @Version 1.0
 **/

public class ThreadTest {

    private static final int sleepTime = 1000;
    private static int start = 2;


    public void test() {
        Thread daemon = new Thread(new Task(start), "interData");
        daemon.start();
        ThreadUtil.sleep(8000);
        System.out.println("isAlive:" + daemon.isAlive());
    }

    public static void main(String[] args) {
        new ThreadTest().test();
    }

    class Task implements Runnable {

        //        private static final int sleepTime = 1000;
        private int data;

        public Task(int data) {
            this.data = data;
        }

        @Override
        public void run() {

            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("thread exception.......");
                    ThreadUtil.sleep(sleepTime * 2);
                    start = 2;
                    System.out.println("thread start.......");
                    System.out.println(t.isAlive());
                    System.out.println(t.isInterrupted());
                    System.out.println(t.getState());

                    new Thread(new Task(start)).start();
//                System.out.println(t.start());
                }
            });


            while (true) {
                System.out.println(DateTime.now()+"  task running........" + data);
                int a = 3 / data;
                ThreadUtil.sleep(sleepTime);
                data--;
            }

        }
    }
}






