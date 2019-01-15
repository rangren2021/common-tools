package com.study.common.server.utils.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassName MyApplicationEvent
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/15 15:56
 * @Version 1.0
 **/
public class MyApplicationEvent extends ApplicationEvent {

    private static final long serialVersionUID = 4614474836288849053L;

    private String msg;

    public MyApplicationEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
