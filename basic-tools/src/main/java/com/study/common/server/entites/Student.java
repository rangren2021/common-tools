package com.study.common.server.entites;

import lombok.Data;

/**
 * @ClassName Student
 * @Description TODO
 * @Author xinbang
 * @Date 2018/12/3 16:01
 * @Version 1.0
 **/
@Data
public class Student {

    private String name; //这些是字段！！不是javabean的属性
    private int age;
}
