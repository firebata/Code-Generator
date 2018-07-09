package com.zlinks.common.utils;


import okhttp3.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: A
 * Author:   zhangjh
 * Date:     2018/3/31 16:03
 * Description: http请求通用方法
 */
public enum OkHttpUtils {
    INSTANCE;
    public static final MediaType CONTENT_TYPE = MediaType.parse("application/json;charset=utf-8");

    private OkHttpClient okHttpClient;

    OkHttpUtils() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(8, TimeUnit.SECONDS);
        builder.writeTimeout(8, TimeUnit.SECONDS);
        builder.connectTimeout(8, TimeUnit.SECONDS);
        builder.followRedirects(false);
        okHttpClient = builder.build();
        okHttpClient.dispatcher().setMaxRequests(2000);
        okHttpClient.dispatcher().setMaxRequestsPerHost(2000);
    }

    /**
     * @param url
     * @param param
     * @param callback
     */
    public void get(String url, Map<String, String> param, Callback callback) {
        Request request = buildGetRequest(url, param);

        okHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * 同步方式调用get
     *
     * @param url
     * @param param
     * @return Response
     * @throws IOException
     */
    public Response get(String url, Map<String, String> param) throws IOException {
        Request request = buildGetRequest(url, param);

        return okHttpClient.newCall(request).execute();
    }

    /**
     * 构建get请求参数
     *
     * @param url
     * @param param
     * @return
     */
    private Request buildGetRequest(String url, Map<String, String> param) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

        if (param != null) {
            Iterator iterator = param.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                urlBuilder.addQueryParameter(key, param.get(key));
            }
        }

        return new Request.Builder()
                .url(urlBuilder.build())
                .get()
                .build();
    }

    /**
     * 异步发送post请求
     *
     * @param url
     * @param content
     * @param callback
     */
    public void post(String url, String content, Callback callback) {
        Request request = buildPostRequest(url, content);

        okHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * 构建post请求参数
     *
     * @param url
     * @param content
     * @return
     */
    private Request buildPostRequest(String url, String content) {
        RequestBody requestBody = RequestBody.create(CONTENT_TYPE, content);

        return new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
    }

    /**
     * 同步发送post请求
     *
     * @param url
     * @param content
     * @return
     * @throws IOException
     */
    public Response post(String url, String content) throws IOException {
        Request request = buildPostRequest(url, content);
        return okHttpClient.newCall(request).execute();
    }


}
