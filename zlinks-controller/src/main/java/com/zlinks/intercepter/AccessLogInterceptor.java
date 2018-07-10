package com.zlinks.intercepter;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.BaseInterceptor;
import com.zlinks.common.utils.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用拦截器，记录请求信息
 *
 * @author : zhangjh on 2017/10/31.
 */
@Component
public class AccessLogInterceptor extends BaseInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    /**
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        String uri = request.getRequestURI();

        if (!uri.contains("/error") && !uri.contains("monitor/telnet")) {
            String ip = IpUtils.INSTANCE.getIpAddress(request);
            Thread.currentThread().setName(ip + "@" + request.getRequestURL());
//            String accessToken = request.getHeader(CommonConstant.ACCESS_TOKEN_FLAG.getValue());
            logger.info("userId:{}|requestParams:{}|requestHeader:{}", getParams(request), JSON.toJSONString(getHeadersInfo(request)));
        }


        return super.preHandle(request, response, handler);
    }


}
