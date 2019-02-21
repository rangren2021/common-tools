package com.study.common.server.utils.generic;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName GenericUtil
 * @Description TODO
 * @Author xinbang
 * @Date 2019/2/21 10:33
 * @Version 1.0
 **/

public class GenericUtil {

    //Map<Class, Class>: Map<类类型, onSuccess方法请求参数类型>
    private static final Map<Class, Class> successfulResponseParamType = new ConcurrentHashMap<Class, Class>();

    //获取泛型接口的具体类型
    private Class getMethodArgumentType() {
        GenericResponseImpl genericResponse = new GenericResponseImpl();
        Class clazz = genericResponse.getClass();
        Class argumentClass = successfulResponseParamType.get(clazz);
        if (argumentClass != null) {
            return argumentClass;
        }
        ParameterizedType parameterizedType = (ParameterizedType) genericResponse.getClass().getGenericInterfaces()[0];
        Class argument = (Class) parameterizedType.getActualTypeArguments()[0];
        successfulResponseParamType.put(clazz, argument);
        return argument;
    }

    public static void main(String[] args) {
        GenericUtil util = new GenericUtil();
        Class clazz = util.getMethodArgumentType();
        System.out.println("clazz:"+clazz);
    }
}
