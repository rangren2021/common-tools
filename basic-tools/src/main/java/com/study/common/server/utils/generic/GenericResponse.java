package com.study.common.server.utils.generic;

/**
 * @ClassName GenericResponse
 * @Description TODO
 * @Author xinbang
 * @Date 2019/2/21 10:35
 * @Version 1.0
 **/

public interface GenericResponse<T> {

    public boolean onSucc(T t);
}
