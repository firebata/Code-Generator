package com.zlinks.common.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendInterSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendInterSmsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.zlinks.common.constants.SysConfigKeyConstant;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import com.yunpian.sdk.model.Template;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author bruce
 * @Date 2017/12/28 20:37
 * @Company bbgame
 * 手机相关工具类
 */

public class MobileUtils {

    private static Logger logger = LoggerFactory.getLogger(MobileUtils.class);

    //云片国际短信发送
    public static Integer sendMobileVerifyCodebyYunPian(String appId, String templateCode, String mobile, String verifyCode) {
        if (StringUtils.isEmpty(appId)) {
            //TODO
            appId = "b33815448c5ad8e0eb0b6c6f2911c700";
        }
        //初始化clnt,使用单例方式
        YunpianClient clnt = null;
        Integer code = 1;
        try {
            clnt = new YunpianClient(appId).init();
            Map<String, String> params = clnt.newParam(2);
            params.put("apikey", appId);
            params.put("tpl_id", templateCode);
            Result<List<Template>> ts = clnt.tpl().get(params);
            Template template = ts.getData().get(0);
            String text = template.getTpl_content();
            text = text.replace("#code#", verifyCode);
            Map<String, String> param = clnt.newParam(2);
            param.put(YunpianClient.MOBILE, "+" + mobile);
            param.put(YunpianClient.TEXT, text);
            Result<SmsSingleSend> result = clnt.sms().single_send(param);
            logger.info("--->yunpian send verifycode of mobile:{}|verifyCode:{}|result:{}", mobile, verifyCode, result);
            code = result.getCode();
        } catch (Exception e) {
            logger.info("yunPianVerifyCodeError:{}", e);
        } finally {
            if (null != clnt) {
                clnt.close();
            }
        }

        return code;
    }

    //阿里云国内短信
    public static Integer sendInteralMobileCodeByAliyun(String mobile) {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        String accessKeyId = "LTAIvvBhik3tLilm";
        String accessKeySecret = "nCMwiYfj9WsJWtkVB6S0GmllhPhNS0";
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            SendSmsRequest request = new SendSmsRequest();
            request.setMethod(MethodType.POST);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            request.setPhoneNumbers(mobile);//发送验证码到多个手机号用逗号分隔
            request.setSignName("BBGAME");
            request.setTemplateCode("SMS_119620001");
            String number = RandomStringUtils.randomNumeric(6);
            String template = "您的验证码有效期5分钟，验证码为" + number;
            Map<String, String> params = new HashMap<>();
            params.put("intlmsg", template);
            String jsonParam = JSON.toJSONString(params);
            request.setTemplateParam(jsonParam);
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            logger.info("mobile:{} return result{} ", mobile, sendSmsResponse.getCode());
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                return 0;
            }
        } catch (Exception e) {
            logger.error("aliyunInternal: {}", e);
            e.printStackTrace();
        }
        return 1;
    }

    //阿里云国际短信发送 暂时不支持国内短信发送
    public static Integer sendMobileVerifyCodeByAliyun(String countryCode, String template, String mobile) {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        final String region = "cn-hangzhou";
        final String accessKeyId = "LTAIvvBhik3tLilm";
        final String accessKeySecret = "nCMwiYfj9WsJWtkVB6S0GmllhPhNS0";

        if (StringUtils.isBlank(template)) {
            template = "SMS_119620001";
        }

        IClientProfile profile = DefaultProfile.getProfile(region, accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint(region, region, product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象-具体描述见控制台-文档部分内容
            SendInterSmsRequest request = new SendInterSmsRequest();

            //根据区域设置区域代码
            if (countryCode.equals(SysConfigKeyConstant.SMS_TPL_TW)) {
                request.setCountryCode(SysConfigKeyConstant.SMS_REGION_TW); //台湾短信
            } else if (countryCode.equals(SysConfigKeyConstant.SMS_TPL_HK)) { //香港短信
                request.setCountryCode(SysConfigKeyConstant.SMS_REGION_HK);
            } else if (countryCode.equals(SysConfigKeyConstant.SMS_TPL_KR) || countryCode.equals(SysConfigKeyConstant.SMS_TPL_JP)) {//韩国日本短信
                request.setCountryCode(SysConfigKeyConstant.SMS_REGION_KR);
            } else if (countryCode.equals(SysConfigKeyConstant.SMS_TPL_CN)) {
                return sendInteralMobileCodeByAliyun(mobile);// 国内短信验证码发送
            }

            //必填:待发送手机号
            request.setPhoneNumbers(mobile);
            //必填:对应国家的国家编号,国家编号的获取详见国际短信国家编码获取API接口

            //必填:短信签名-可在短信控制台中找到(必须是国际短信模板)
            request.setTemplateCode(template);
            //短信签名
            request.setSignName(SysConfigKeyConstant.SMS_SIGNNAME);
            //必填,短信内容
            String number = RandomStringUtils.randomNumeric(6);
            String templateContent = "您的驗證碼有效期5分鐘，驗證碼為" + number;
            Map<String, String> params = new HashMap<>(1);
            params.put("intlmsg", templateContent);
            request.setTemplateParam(JSON.toJSONString(params));
            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId("your_outId");
            //hint 此处可能会抛出异常，注意catch
            SendInterSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            logger.info("mobile: {} aliyunVerfifyCode：{}", mobile, sendSmsResponse.getCode());
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                return 0;
            }
        } catch (Exception e) {
            logger.error("aliyunInternal: {}", e);
            e.printStackTrace();
        }
        return 1;
    }


}
