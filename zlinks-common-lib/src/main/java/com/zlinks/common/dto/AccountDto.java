package com.zlinks.common.dto;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.enums.UserOpenType;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountDto extends BaseDto {

    private Long gameUserId;

    private String mobile;

    private String nickName;

    private String password;

    @JsonIgnore
    private int state;

    private String account;

    /**
     * 登录后的accessToken
     */
    public String accessToken;
    /**
     * 0:新建账号  1:非新建账号
     */
    private boolean isCreate = false;


    private String token;

    private String userUid;

    private Long expiresIn;

    private String refreshToken;

    private String verifyCode;

    private String countryCode;

    private String serverId;

    private String roleName;

    private String deleteFlag;

    private String managerAccount;


    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}
