package com.study.common.server.utils;

import com.study.common.server.InterTest4;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName Test4
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/12 15:29
 * @Version 1.0
 **/

public class Test4 implements InterTest4<String> {

    public Test4(){
        ParameterizedType parameterizedType = (ParameterizedType) Test4.class.getGenericInterfaces()[0];
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Test4 test4 = new Test4();
        System.out.println(System.currentTimeMillis()-start);

//        System.out.println(types.getTypeName());
//        System.out.println(test4.getType());
//        Type[] genericType = ((ParameterizedType) types).getActualTypeArguments();
//        for (Type t : genericType) {
//            System.out.println(t.getTypeName());
//        }
    }

}
