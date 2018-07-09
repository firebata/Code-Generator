package com.zlinks.common.enums;

/**
 * Created by Lyle on 2018/05/08.
 */
public enum InheritanceCodeType {

    USER("USER"),ADMIN("ADMIN");

    private String value;

    InheritanceCodeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
