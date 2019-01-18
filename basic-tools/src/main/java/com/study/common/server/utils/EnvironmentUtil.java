package com.study.common.server.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @ClassName EnvironmentUtil
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/16 15:28
 * @Version 1.0
 **/
@Component
public class EnvironmentUtil {

    @Autowired
    private Environment environment;

    public String getInfo(){
        return environment.getProperty("user.dir");
    }

//    public String[] getInfos(){
//        return environment.;
//    }

    public String[] getDefaultInfos(){
        return environment.getDefaultProfiles();
    }
}
