package com.study.common.server.utils.aop;

/**
 * @ClassName MethodBeforeAdvice
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/9 14:54
 * @Version 1.0
 **/

public class MethodBeforeAdvice implements Advice{


    @Override
    public void execute() {
        System.out.println("this is method before advice!");
    }
}
