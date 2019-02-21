package com.study.common.server.utils.generic;

/**
 * @ClassName GenericResponseImpl
 * @Description TODO
 * @Author xinbang
 * @Date 2019/2/21 10:36
 * @Version 1.0
 **/

public class GenericResponseImpl implements GenericResponse<Integer> {


    @Override
    public boolean onSucc(Integer integer) {
        System.out.println("integer");
        return false;
    }
}
