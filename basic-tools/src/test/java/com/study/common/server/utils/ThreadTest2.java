package com.study.common.server.utils;

/**
 * @ClassName ThreadTest2
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/8 20:36
 * @Version 1.0
 **/

public class ThreadTest2 {

    private static class Inner {

        private String var = "123123";

        public String getVar() {
            return var;
        }

        public void setVar(String var) {
            this.var = var;
        }
    }


    public static void main(String[] args) {
        Inner inner = new Inner();
        System.out.println("1-->"+inner.getVar());


        new Thread(new Runnable() {
            @Override
            public void run() {
                Inner inner = new Inner();
                System.out.println("2-->"+inner.getVar());
                inner.setVar("hello");
                System.out.println("3-->"+inner.getVar());
            }
        }).start();
        System.out.println("4-->"+inner.getVar());
        Inner inner1 = new Inner();
        System.out.println("5-->"+inner1.getVar());

    }
}
