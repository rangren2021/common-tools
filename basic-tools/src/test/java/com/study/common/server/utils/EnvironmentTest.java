package com.study.common.server.utils;

import com.study.common.server.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @ClassName EnvironmentTest
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/16 15:29
 * @Version 1.0
 **/

public class EnvironmentTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        EnvironmentUtil util = applicationContext.getBean(EnvironmentUtil.class);
//        System.out.println("res:"+util.getInfo());

//        System.out.println("res:"+ Arrays.toString(util.getInfos()));

//        System.out.println("default:"+ Arrays.toString(util.getDefaultInfos()));

//        Map<String, Object> systemProperties = applicationContext.getEnvironment().getSystemProperties();
        Map<String, Object> systemEnvironment = applicationContext.getEnvironment().getSystemEnvironment();

        showMap(systemEnvironment);
    }

    private static void showMap(Map<String, Object> maps) {
        if (maps != null && !maps.isEmpty()) {
            for (Map.Entry<String, Object> item : maps.entrySet()) {
                System.out.println(item.getKey()+"<---->"+item.getValue());
            }
        }
        System.out.println("-----------end----------");

    }
}
