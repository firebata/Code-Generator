package com.zlinks.common.constants;

/**
 * 常量管理
 */
public enum CommonConstant {
    ANDROID("android"),
    IOS("ios"),
    SUCCESS("success"),
    EMPTY(""),
    AT("@"),
    POUND("#"),
    COMMA(","),
    ZERO("0"),
    ONE("1"),
    yyyyMMddHH("yyyy-MM-dd-HH"),
    yyyyMMddHHmmss("yyyy-MM-dd HH:mm:ss"),
    FIELD_SIGN("sign"),
    MD5("MD5"),
    FAIL("fail"),
    MINUS("-"),
    HMACSHA256("HMACSHA256"),

    CD_ERROR("1"),
    CD_OK("0"),
    COLON(":"),
//    REDIS_USER_TOKEN_PREFIX("user_token_"),
    REDIS_ACCESS_TOKEN_PREFIX("access_token_"),
    REDIS_REFRESH_TOKEN_PREFIX("refresh_token_"),
    REDIS_TOKEN_USERID_PREFIX("userid_token_"),
    PERCENT_S("%s"),
    ASTERISK("*"),
    ACCESS_TOKEN_FLAG("accessToken"),
    ACCOUNT_DEFAULT_PASSWORD("F59BD65F7EDAFB087A81D4DCA06C4910"),
    EQUALS("="),
    KEY_EXPPACKAGES("key:exppackages"),
    SESSION_FLAG("bbgame:session:login:"),



    ;

    public static final String[] CD2 = {"2", "param is error:"};
    public static final String[] CD1 = {"1", "Fail"};
    public static final String[] CD0 = {"0", "Success"};

    CommonConstant(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
