package com.study.common.server.config;

import com.study.common.server.utils.aop.demo.LogIntercepter;
import com.study.common.server.utils.aop.demo.MathCalendar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName Config
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/9 17:48
 * @Version 1.0
 **/

@EnableAspectJAutoProxy
@Configuration
public class AopConfig {

    @Bean
    public LogIntercepter calculator() {
        return new LogIntercepter();
    }

    @Bean
    public MathCalendar logAspects() {
        return new MathCalendar();
    }


}
