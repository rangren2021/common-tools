package com.study.common.server.utils;

import com.study.common.server.config.AopConfig;
import com.study.common.server.config.Config;
import com.study.common.server.utils.event.MyPublish;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName EventTest
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/15 16:48
 * @Version 1.0
 **/

public class EventTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        MyPublish myPublish = applicationContext.getBean(MyPublish.class);
        myPublish.publish();
    }
}
