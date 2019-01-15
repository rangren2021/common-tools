package com.study.common.server.utils.aop;

/**
 * @ClassName MethodBefore
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/9 11:59
 * @Version 1.0
 **/

public class MethodBefore implements MethodInterceptor {


    private MethodBeforeAdvice methodBeforeAdvice;

    public MethodBefore(MethodBeforeAdvice methodBeforeAdvice) {
        this.methodBeforeAdvice = methodBeforeAdvice;
    }

    @Override
    public Object invoke(MethodInvocation invocation) {
        methodBeforeAdvice.execute();
        return null;
    }
}
