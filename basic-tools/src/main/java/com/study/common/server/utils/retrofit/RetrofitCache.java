package com.study.common.server.utils.retrofit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xinbang on 2018/6/25.
 */
public class RetrofitCache {

    private static LoadingCache<String, RetrofitApi> retrofit = CacheBuilder.newBuilder()
            .concurrencyLevel(Runtime.getRuntime().availableProcessors()).expireAfterWrite(60, TimeUnit.SECONDS)
            .initialCapacity(10).build(new CacheLoader<String, RetrofitApi>() {

                @Override
                public RetrofitApi load(String key) throws Exception {
                    return betrofitApi(key);
                }
            });

    private static RetrofitApi betrofitApi(String url) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(3000, TimeUnit.SECONDS);
        builder.readTimeout(3000, TimeUnit.SECONDS);
        builder.writeTimeout(3000, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).client(builder.build()).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(RetrofitApi.class);
    }

    public static RetrofitApi getRetrofitApi(String url) {
        try {
            return retrofit.get(url);
        } catch (ExecutionException e) {
            return null;
        }
    }

}
