package com.study.common.server.utils;

import com.study.common.server.config.Config;
import com.study.common.server.utils.aop.demo.MathCalendar;
import org.junit.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName AopTest
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/9 17:50
 * @Version 1.0
 **/
public class AopTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        MathCalendar calendar = applicationContext.getBean(MathCalendar.class);
        if(calendar!=null){
            System.out.println("res:"+calendar.add(100,32));
        }
    }
}
