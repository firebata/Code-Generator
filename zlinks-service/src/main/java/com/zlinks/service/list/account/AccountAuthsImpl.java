package com.zlinks.service.list.account;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.web.PageResult;
import com.zlinks.common.web.RestDoing;
import com.zlinks.repository.dao.AccountAuthDO;
import com.zlinks.repository.domain.AuthInfo;
import com.zlinks.repository.mapper.AuthMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2017-2018, BBG
 * FileName: AccountAuthsImpl
 * Author:   zhangjh
 * Date:     2018/6/12 10:14
 * Description:
 */
@Service
public class AccountAuthsImpl implements IAccountAuths {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthMapper authMapper;

    @Override
    public PageResult selectUserAuths(AuthInfo pageInfo) {
        SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = authMapper.countUserAuths(pageInfo);

            List<AccountAuthDO> userAuthDOS = authMapper.selectUserAuths(pageInfo);

            pageResult.list = userAuthDOS;
            pageResult.totalCount = totalCount;
        };
        return doing.go(pageInfo, logger);
    }
}
