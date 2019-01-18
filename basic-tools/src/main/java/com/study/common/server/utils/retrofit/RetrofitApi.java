package com.study.common.server.utils.retrofit;

import com.xinbang.inter.common.dto.base.FunctionResponse;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;


@Component
public interface RetrofitApi {

    @GET
    Call<FunctionResponse> getQueryInter(@Url String url, @HeaderMap Map<String, Object> headers, @QueryMap Map<String, Object> param);

    @FormUrlEncoded
    @POST
    Call<FunctionResponse> postQueryInter(@Url String url, @HeaderMap Map<String, Object> headers, @QueryMap Map<String, Object> param, @FieldMap Map<String, Object> params);

}
