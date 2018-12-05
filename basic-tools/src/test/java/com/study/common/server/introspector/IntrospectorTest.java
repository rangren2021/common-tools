package com.study.common.server.introspector;

import com.alibaba.fastjson.JSON;
import com.study.common.server.entites.Student;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName IntrospectorTest
 * @Description TODO
 * @Author xinbang
 * @Date 2018/12/3 15:17
 * @Version 1.0
 **/

public class IntrospectorTest {

    private static Method getMethod(MethodDescriptor[] methodDescriptors, String name) {

        for (MethodDescriptor descriptor : methodDescriptors) {
            Method method = descriptor.getMethod();
            if (method.getName().equals(name)) {
                return method;
            }
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Student stu = new Student();
        try {
            BeanInfo beaninfo = Introspector.getBeanInfo(stu.getClass());
            PropertyDescriptor[] propertyDescriptors = beaninfo.getPropertyDescriptors();
            Arrays.stream(propertyDescriptors).forEach(descriptors ->{
//                System.out.print("-propertyDescriptors->"+descriptors.getWriteMethod());
                System.out.println("-propertyDescriptors->"+ JSON.toJSONString(descriptors));

            });

            MethodDescriptor[] methodDescriptors = beaninfo.getMethodDescriptors();
            Arrays.stream(methodDescriptors).forEach(descriptors ->{
//                System.out.print("-methodDescriptors->"+descriptors.getDisplayName());
                System.out.println("-methodDescriptors->"+ JSON.toJSONString(descriptors));
            });

            Method method = getMethod(methodDescriptors, "setName");
            if (method == null) {
                throw new NoSuchMethodException(
                        "No setter for property 'setName'");
            }

            Class<?>[] paramTypes = method.getParameterTypes();
            if(paramTypes == null){
                throw new NoSuchMethodException(
                        "No param for property 'setName'");
            }

            try {
                System.out.println("res--->"+method.invoke(stu,"asdfas"));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
