package com.study.common.server.exec;

import java.util.UUID;

/**
 * @ClassName Test10
 * @Description TODO
 * @Author xinbang
 * @Date 2018/12/5 17:16
 * @Version 1.0
 **/

public class Test10 {


    public static void main(String[] args) {
        String n1 = UUID.randomUUID().toString();
        String n2 = UUID.nameUUIDFromBytes("group1".getBytes()).toString();

        System.out.println("n1:"+n1);
        System.out.println("n2:"+n2);

        System.out.println(String.format("%s-@@%s", n2.substring(24), n1));
    }
}
