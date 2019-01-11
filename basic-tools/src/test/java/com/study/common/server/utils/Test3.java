package com.study.common.server.utils;

/**
 * @ClassName Test3
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/9 12:10
 * @Version 1.0
 **/

public class Test3 {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    public static void main(String[] args) {
        System.out.println("COUNT_BITS:"+ COUNT_BITS);
        System.out.println("res:"+( -1 << COUNT_BITS));
    }
}
