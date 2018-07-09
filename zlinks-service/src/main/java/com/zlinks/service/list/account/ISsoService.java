package com.zlinks.service.list.account;

import com.zlinks.repository.domain.Account;
import com.zlinks.repository.dto.AccountDto;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: ISsoService
 * Author: zhangjh
 * Date: 2018/6/22 下午2:54
 * Description:
 */
public interface ISsoService {
    AccountDto signin(Account account);
}
