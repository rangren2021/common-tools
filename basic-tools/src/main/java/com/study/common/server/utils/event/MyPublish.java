package com.study.common.server.utils.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyPublish
 * SimpleApplicationEventMulticaster
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/15 16:35
 * @Version 1.0
 **/
@Component
public class MyPublish implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publish() {
        MyApplicationEvent event = new MyApplicationEvent(this, "自定义消息发布");
        System.out.println("开始发布消息："+event);
        applicationContext.publishEvent(event);
    }
}
