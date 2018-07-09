package com.zlinks.common.aop;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.constants.BaseResultCodeConstant;
import com.zlinks.common.dto.AccountDto;
import com.zlinks.common.enums.UserOpenType;
import com.zlinks.common.utils.IpUtils;
import com.zlinks.common.web.JsonResult;
import org.apache.catalina.session.StandardSessionFacade;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangjh
 * @date 2017/11/30 22:26
 */
@Component
@Aspect
public class WebControllerAop {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private BandService bandService;


    @Pointcut("execution(* com.zlinks.*.controller..*.*(..))  && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {

    }


    /**
     * 拦截器具体实现
     *
     * @param pjp
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("controllerMethodPointcut()")
    public Object Interceptor(ProceedingJoinPoint pjp) {

        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        //获取被拦截的方法名
        Method method = signature.getMethod();
        RequestMapping object = method.getAnnotation(RequestMapping.class);
        String[] values = object.value();
        RequestMethod[] requestMethods = object.method();
        String methodName = Arrays.asList(values).toString();
        String requestMethod = Arrays.asList(requestMethods).toString();
        //保存所有请求参数，用于输出到日志中
        Set<Object> allParams = new LinkedHashSet<>();

        if (!methodName.contains(monitoerUrl)) {

            logger.info(startFormart);
        }


        Object result = null;
        String[] names = signature.getParameterNames();
        Object[] args = pjp.getArgs();

        //封禁相关参数
        String devUniqueId = "";
        String ip = "";
        String adId = "";
        String account = "";
        UserOpenType openType = null;
        int index = 0;
        for (Object arg : args) {

            if (arg instanceof Map<?, ?>) {
                //提取方法中的MAP参数，用于记录进日志中
                Map<String, Object> map = (Map<String, Object>) arg;
                allParams.add(map);
            } else if (arg instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) arg;
                ip = IpUtils.INSTANCE.getIpAddress(request);
                devUniqueId = request.getHeader("devUniqueId");
                adId = request.getHeader("adId");
                Map<String, String[]> paramMap = request.getParameterMap();
                if (paramMap != null && paramMap.size() > 0) {
                    allParams.add(paramMap);
                }
            } else if (arg instanceof HttpServletResponse) {
                //do nothing...
            } else {
                if ((arg instanceof String) || (arg instanceof Long) || (arg instanceof Double) || (arg instanceof BigDecimal)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(leftBracketsStr);
                    stringBuilder.append(names[index]);
                    stringBuilder.append(colonStr);
                    stringBuilder.append(arg);
                    stringBuilder.append(rigtBracketsStr);
                    allParams.add(stringBuilder.toString());
                } else {
                    if (!(arg instanceof StandardSessionFacade)) {
                        allParams.add(JSON.toJSONString(arg));
                        if (arg instanceof AccountDto) {
                            AccountDto userDto = (AccountDto) arg;
                            account = userDto.getAccount();
                            if(userDto.getOpenType() != null){
                                openType = userDto.getOpenType();
                            }
                        }
                    }
                }

            }
            index++;
        }

        //注册和登陆对用户频率进行拦截
//        if (methodName.contains(loginUrl) || methodName.contains(registerUrl)|| methodName.contains("users/signin")) {
//            bandService.judgeBandCommonInfo(ip, devUniqueId, adId);
//            if (!methodName.contains(registerUrl))
//                bandService.judgeBandAccountInfo(account, openType);
//        }

        try {
            if (result == null) {
                // 一切正常的情况下，继续执行被拦截的方法
                if (!methodName.contains(monitoerUrl)) {
                    logger.info(paramFormat, allParams);
                }
                result = pjp.proceed();
            }
        } catch (Throwable e) {
            logger.error(expFormatStr, e);
            result = new JsonResult(BaseResultCodeConstant.FAILED.getCode(), BaseResultCodeConstant.FAILED.getMsg());
        } finally {
            if (!methodName.contains(monitoerUrl)) {
                if (result instanceof JsonResult) {
                    JsonResult jsonResult = (JsonResult) result;
                    logger.info("======================{},result:{}======================", jsonResult);
                }
                long costMs = System.currentTimeMillis() - beginTime;
                logger.info(countFormatStr,costMs);
            }

        }


        return result;
    }


    static String loginUrl = "/users/login";
    static String registerUrl = "/users/register";
    static String monitoerUrl = "/monitor/telnet/info";
    static String leftBracketsStr = "{\"";
    static String colonStr = "\":\"";
    static String rigtBracketsStr = "\"}";
    static String startFormart = "======================>start";
    static String paramFormat = "======================>param:{}";
    static String expFormatStr = "======================>exception: ";
    static String countFormatStr = "======================spend：{} ms======================";
}
