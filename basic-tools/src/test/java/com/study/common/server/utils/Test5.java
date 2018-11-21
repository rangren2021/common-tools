package com.study.common.server.utils;

import java.util.regex.Pattern;

/**
 * @ClassName Test5
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/13 11:56
 * @Version 1.0
 **/

public class Test5 {

    public static void main(String[] args) {
//        boolean res = Pattern.matches("[a-zA-Z0-9_]*", "asdfawe434efvg");
//        System.out.println(res);
        String str = "/asdf/asdfd";
        System.out.println(str.replaceAll("//", ""));
    }
}
