package com.zlinks.service.util;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.constants.CommonConstant;
import com.zlinks.common.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangjh on 2017/12/10.
 * httpClient 请求工具类
 */
public class HttpClientUtils {
    private static final int HttpConnnectTimeout = 10 * 1000;
    private static final int HttpSoTimeout = 10 * 1000;

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String doGetRequest(String url, Map<String, String> params) throws IOException {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        StringBuilder builder = new StringBuilder(url);
        if (builder.indexOf("?") == -1) {
            builder.append("?t=").append(System.currentTimeMillis());
        } else {
            builder.append("&t=").append(System.currentTimeMillis());
        }
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.append("&").append(entry.getKey()).append(CommonConstant.EQUALS.getValue()).append(entry.getValue());
            }
        }
        Request request = new Request.Builder()
                .url(builder.toString())
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                return null;
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String doPostRequest(String url, Map<String, String> params) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        FormBody.Builder buider = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            buider.add(entry.getKey(), entry.getValue());
        }

        Request request = new Request.Builder()
                .url(url)
                .post(buider.build())
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + "url:" + url + ",requestTime: " + TimeUtils.getCurrentTimestamp(), e);
            return null;
        }
    }

    /**
     * @param url
     * @param params
     * @param type
     * @return
     * @throws IOException
     */
    public static String doPostRequest(String url, Map<String, String> params, MediaType type) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        String jsonString = JSON.toJSONString(params);


        RequestBody body = RequestBody.create(type, jsonString);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }

        } catch (Exception e) {
            logger.error(e.getMessage() + "url:" + url + ",requestTime: " + TimeUtils.getCurrentTimestamp(), e);
        }

        return null;
    }

    /**
     * 通用get请求
     *
     * @param url
     * @param params
     * @param connectTimeOut
     * @param readTimeOut
     * @return
     */
    public static Object doGetRequest(String url, Map<String, String> params, long connectTimeOut, long readTimeOut) {
        if (connectTimeOut == 0 || readTimeOut == 0) {
            connectTimeOut = 30;
            readTimeOut = 30;
        }
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
                .readTimeout(readTimeOut, TimeUnit.SECONDS)
                .build();

        StringBuilder builder = new StringBuilder(url);
        if (params != null && !params.isEmpty()) {
            builder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        Request request = new Request.Builder()
                .url(builder.substring(0, builder.toString().length() - 1).toString())
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                return null;
            }

        } catch (Exception e) {
            logger.error("base get request error: " + e.getMessage(), e);
            return null;
        }

    }


}
