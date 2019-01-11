package com.study.common.server.utils.aop.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @ClassName LogIntercepter
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/9 16:02
 * @Version 1.0
 **/
@Aspect
public class LogIntercepter {

    @Pointcut("execution(public double com.study.common.server.utils.aop.demo.MathCalendar.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void start(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("before " + joinPoint.getSignature().getName() + " 参数列表：" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void end(JoinPoint joinPoint) {
        System.out.println("after " + joinPoint.getSignature().getName() + " 结束");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void returning(JoinPoint joinPoint, Object result) {
        System.out.println("return " + joinPoint.getSignature().getName() + "正常返回，结果是：" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void returnException(JoinPoint joinPoint, Exception exception) {
        System.out.println("exception " + joinPoint.getSignature().getName() + "异常，异常信息：" + exception);
    }


}
