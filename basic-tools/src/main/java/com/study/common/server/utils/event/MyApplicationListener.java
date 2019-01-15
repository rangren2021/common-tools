package com.study.common.server.utils.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyApplicationListener
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/15 16:29
 * @Version 1.0
 **/
@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {


    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println("MyApplicationListener :" + event);
        System.out.println("MyApplicationListener.msg:" + event.getMsg());
    }
}
