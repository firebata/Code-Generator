package com.zlinks.common.constants;

/**
 * 基础返回码
 */
public enum BaseResultCodeConstant {

    SUCCESS(0, "Success"),
    FAILED(1, "Fail"),
    PAGE_SIZE_MORE_THAN_2000(1001, "PageSize is too large,it must be less than 2001");


    private int code;
    private String msg;

    BaseResultCodeConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultCodeConstant{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
