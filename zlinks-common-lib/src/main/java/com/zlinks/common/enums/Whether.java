package com.zlinks.common.enums;

/**
 * Created by zhangjh on 2017/10/10.
 * 是否的枚举
 */
public enum Whether {
    YES("是"), NO("否");

    Whether(String text) {
        this.text = text;
    }

    private int sort;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
