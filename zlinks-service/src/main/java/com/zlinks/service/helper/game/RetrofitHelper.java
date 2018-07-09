package com.zlinks.service.helper.game;

import retrofit2.Retrofit;

/**
 * 创建Retrofit
 * Created by zhangjh on 2017/11/29.
 */
public enum RetrofitHelper {
    INSTANCE;


    /**
     * @param url
     * @return
     */
    public Retrofit getRetrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .build();
        return retrofit;
    }
}
