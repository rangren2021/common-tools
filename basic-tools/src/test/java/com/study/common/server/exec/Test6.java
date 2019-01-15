package com.study.common.server.exec;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Properties;


public class Test6 {

    public static void main(String[] args) {

//        try {
//            System.out.println(InetAddress.getLocalHost().getHostName() + System.currentTimeMillis());
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }

        URL url = Test6.class.getResource("org.quartz.properties");
        Properties prop = System.getProperties();
//        prop.load("");



    }

}
