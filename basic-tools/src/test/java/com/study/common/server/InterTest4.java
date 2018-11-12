package com.study.common.server;

/**
 * Created by xinbang on 2018/11/12.
 */
public interface InterTest4<T> {

    default Class getType() {
        return getClass();
    }

}
