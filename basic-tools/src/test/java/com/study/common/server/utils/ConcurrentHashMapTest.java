package com.study.common.server.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ConcurrentHashMapTest
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/12 11:53
 * @Version 1.0
 **/

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Map<String, String> data = new ConcurrentHashMap();
        String value1 = data.putIfAbsent("aaa","123");
        System.out.println("value1:"+value1);
        String value2 = data.putIfAbsent("aaa","456");
        System.out.println("value2:"+value2);
        String value3 = data.putIfAbsent("aaa","789");
        System.out.println("value3:"+value3);


    }
}
