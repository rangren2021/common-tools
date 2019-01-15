package com.study.common.server.exec;

import com.alibaba.fastjson.JSON;
import com.xinbang.inter.client.InterClient;
import com.xinbang.inter.client.po.BaiPosition;

/**
 * @ClassName Test11
 * @Description TODO
 * @Author xinbang
 * @Date 2018/10/26 10:22
 * @Version 1.0
 **/

public class Test11 {

    public static void main(String[] args) {
        InterClient client = new InterClient();
        BaiPosition position = client.getGaodeAPI("116.310003,39.991957");
        System.out.println("res-->"+JSON.toJSONString(position));


    }

}
