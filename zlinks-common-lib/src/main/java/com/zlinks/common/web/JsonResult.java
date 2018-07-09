package com.zlinks.common.web;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.constants.BaseResultCodeConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by zhangjh on 2017/10/10.
 */
public class JsonResult<T> {

    private Integer code = BaseResultCodeConstant.SUCCESS.getCode();
    private String desc = BaseResultCodeConstant.SUCCESS.getMsg();
    private String timestamp;
    public T data;


    public JsonResult() {
    }


    public JsonResult(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    private void saveJsonResult(BaseResultCodeConstant resultCodeConstant) {
        this.code = resultCodeConstant.getCode();
        this.desc = resultCodeConstant.getMsg();
    }

    public void errorParam(String desc, Logger log) {
        this.code = BaseResultCodeConstant.FAILED.getCode();
        this.desc = BaseResultCodeConstant.FAILED.getMsg() + desc;
        log.error("error code:{}|desc:{}", code, desc);

    }

    public void errorParam(int code, String desc, Logger log) {
        custom(code, desc, log);
    }

    public void custom(int code, String desc, Logger log) {
        this.code = code;
        this.desc = desc;
//        log.error("error code:{}|desc:{}", code, desc);
    }

    public void saveResult(int codeInput, Logger log) {
        saveResult(codeInput, null, null);
    }

    public void saveResult(int codeInput, String desc, Logger log) {
        switch (codeInput) {
            case 0:
                saveJsonResult(BaseResultCodeConstant.SUCCESS);
                break;
            default:
                saveJsonResult(BaseResultCodeConstant.FAILED);
                break;

        }

        if (StringUtils.isNotBlank(desc)) {
            setDesc(desc);
        }

        if (null != log) {
            log.error("error code:{}|desc:{}", code, desc);
        }


    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void go(Logger logger) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement s : stackTrace) {
            logger.error(s.getClassName() + ",-" + s.getMethodName() + ":["
                    + " " + s.getLineNumber() + "]");
        }
    }


    public JsonResult build(int code, String desc) {
        this.code = code;
        this.desc = desc;
        LocalDateTime arrivalDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        String timestamp = arrivalDate.format(format);
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }

}
