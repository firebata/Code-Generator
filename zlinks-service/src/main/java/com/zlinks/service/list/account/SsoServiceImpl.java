package com.zlinks.service.list.account;

import com.zlinks.common.exception.BusinessException;
import com.zlinks.repository.constants.ResultCodeConstant;
import com.zlinks.repository.domain.Account;
import com.zlinks.repository.domain.AccountGame;
import com.zlinks.repository.dto.AccountDto;
import com.zlinks.repository.mapper.AccountGameMapper;
import com.zlinks.repository.mapper.AccountMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: SsoServiceImpl
 * Author: zhangjh
 * Date: 2018/6/22 下午2:54
 * Description:
 */
@Component
public class SsoServiceImpl implements ISsoService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountGameMapper accountGameMapper;

    @Override
    public AccountDto signin(Account accountInput) {
        AccountDto accountDto = new AccountDto();

        //查找用户信息
        if (StringUtils.isBlank(accountInput.getAccount())) {
            throw new BusinessException(ResultCodeConstant.ACCOUNT_IS_NUll.getCode(), ResultCodeConstant.ACCOUNT_IS_NUll.getMsg());
        } else if (StringUtils.isBlank(accountInput.getPassword())) {
            throw new BusinessException(ResultCodeConstant.PASSWORD_IS_NUll.getCode(), ResultCodeConstant.PASSWORD_IS_NUll.getMsg());
        }
        Account account = accountMapper.findByAccountAndPassword(accountInput);
        if (null == account) {
            throw new BusinessException(ResultCodeConstant.USER_IS_NOT_EXIST.getCode(), ResultCodeConstant.USER_IS_NOT_EXIST.getMsg());
        }
        //查找用户信息
        List<AccountGame> accountGames =accountGameMapper.findByUserId(accountInput.getUserId());


        //设置token


        return accountDto;
    }
}
