package com.study.common.server.utils;

import com.study.common.server.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
//        MathCalendar calendar = applicationContext.getBean(MathCalendar.class);
//        if(calendar!=null){
//            System.out.println("res:"+calendar.add(100,32));
//        }
        applicationContext.refresh();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();

    }
}
