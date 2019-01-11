package com.study.common.server.utils.aop;

/**
 * @ClassName MethodInterceptor
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/9 11:55
 * @Version 1.0
 **/

public interface MethodInterceptor {

    Object invoke(MethodInvocation invocation);

}
