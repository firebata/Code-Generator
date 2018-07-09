package com.zlinks.common.web;


import com.zlinks.common.constants.BaseResultCodeConstant;
import com.zlinks.common.dto.pager.PagerInfo;
import com.zlinks.common.exception.BusinessException;

import java.lang.reflect.Type;

/**
 * 分页信息
 * Created by zhangjh on 2017/10/10.
 */
public class BaseController<T> {


    /**
     * 分页数据处理
     *
     * @param pagerInfo
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T getPageBy(PagerInfo pagerInfo, Type type) {
        if (pagerInfo == null) {
            pagerInfo = new PagerInfo(1, 20);
        } else {
            if (pagerInfo.getPageNo() == null) {
                pagerInfo.setPageNo(1);
            }
            if (pagerInfo.getPageSize() == null) {
                pagerInfo.setPageSize(20);
            } else if (pagerInfo.getPageSize() > 2000) {
                throw new BusinessException(BaseResultCodeConstant.PAGE_SIZE_MORE_THAN_2000.getCode(), BaseResultCodeConstant.PAGE_SIZE_MORE_THAN_2000.getMsg());
            }
        }
        pagerInfo.setLimit(pagerInfo.getPageSize());
        pagerInfo.setStart((pagerInfo.getPageNo() - 1) * pagerInfo.getPageSize());
        T t = (T) pagerInfo;
        return (T) t;
    }

    public static <T> T getPage(PagerInfo pagerInfo, Class<T> clazz) {
        return (T) getPageBy(pagerInfo, (Type) clazz);
    }
}
