package com.zlinks.common.enums;

/**
 *
 */
public enum ResetPasswordType {
    ALL("ALL"), MOBILE("mobile"), EMAIL("email"), UPDATE("update");

    private String value;

    ResetPasswordType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
