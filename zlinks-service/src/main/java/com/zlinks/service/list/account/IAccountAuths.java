package com.zlinks.service.list.account;

import com.zlinks.common.web.PageResult;
import com.zlinks.repository.dao.AccountAuthDO;
import com.zlinks.repository.domain.AuthInfo;

import java.util.List;

/**
 * Copyright (C), 2017-2018, BBG
 * FileName: IAccountAuths
 * Author:   zhangjh
 * Date:     2018/6/12 10:13
 * Description: 用户权限接口
 */
public interface IAccountAuths {
    PageResult selectUserAuths(AuthInfo pageInfo);

}
