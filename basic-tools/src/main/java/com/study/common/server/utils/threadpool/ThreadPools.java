package com.study.common.server.utils.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadPools
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/9 10:53
 * @Version 1.0
 **/

public class ThreadPools {

    private static final ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        service.submit(() -> {
            return "";
        });


    }

}
