package com.study.common.server.utils;

import com.study.common.server.utils.retrofit.RetrofitApi;
import com.study.common.server.utils.retrofit.RetrofitCache;
import com.xinbang.inter.common.dto.base.FunctionResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HttpUtils
 * @Description TODO
 * @Author xinbang
 * @Date 2018/10/26 14:28
 * @Version 1.0
 **/

public class HttpUtils {

    public static void main(String[] args) {
//        http://192.168.1.71:6013/inter-center/api/doPost
        RetrofitApi api = RetrofitCache.getRetrofitApi("http://192.168.1.71:6013");
        Map<String, Object> req = new HashMap<>();
        req.put("functionId", "e9a2172049564ba0bfe68bf1e6bf10a8");
        req.put("userId", "84cad2dc57164566a595cab70ddfd7cf");
        req.put("ip", "115.196.160.108");
        Call<FunctionResponse> call = api.postQueryInter("/inter-center/api/doPost", new HashMap<String, Object>(), req, new HashMap<String, Object>());
        try {
            Response<FunctionResponse> response = call.execute();
//            System.out.println(response.body().toString());
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
