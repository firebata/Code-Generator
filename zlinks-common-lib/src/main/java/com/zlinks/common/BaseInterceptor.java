package com.zlinks.common;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: interceptor
 * Author: zhangjh
 * Date: 2018/7/10 下午5:58
 * Description:
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {


    /**
     * 请求参数记录
     *
     * @param request
     */
    protected String getParams(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuffer parameterStringBuffer = new StringBuffer("request params=>{ ");
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            parameterStringBuffer.append(parameterName).append(" : ").append(request.getParameter(parameterName)).append(" ,");
        }
        parameterStringBuffer.deleteCharAt(parameterStringBuffer.length() - 1);
        parameterStringBuffer.append(" }");
        return parameterStringBuffer.toString();
    }


    protected Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

}
