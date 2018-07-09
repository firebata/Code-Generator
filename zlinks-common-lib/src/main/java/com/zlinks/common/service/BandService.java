package com.zlinks.common.service;

import com.zlinks.common.enums.UserOpenType;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: BandService
 * Author: Lyle
 * Date: 2018/5/14 20:10
 * Description:
 */
public interface BandService {

    void judgeBandCommonInfo(String ip, String devUniqueId, String adId);

    void judgeBandAccountInfo(String account, UserOpenType openType);
}
