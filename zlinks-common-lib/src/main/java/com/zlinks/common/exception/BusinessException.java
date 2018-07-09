package com.zlinks.common.exception;

/**
 * Created by zhangjh on 2017/10/10.
 */
public class BusinessException extends RuntimeException {

    public int code;

    public String desc;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private BusinessException(String desc) {
        this.desc = desc;
    }

//    public <T> BusinessException(Enum enuma, Class<T> className) {
//
//        this.desc = desc;
//    }

    public BusinessException(int code, String desc) {
        super(desc);

        this.desc = desc;
        this.code = code;
    }

}
