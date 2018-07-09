package com.zlinks.common.db;

import com.zlinks.common.BaseDoing;
import com.zlinks.common.dto.pager.PagerInfo;
import com.zlinks.common.web.PageResult;
import com.google.common.collect.Lists;
import org.slf4j.Logger;

/**
 * Created by zhangjh on 2017/10/10.
 * 分页sql查询
 */
@FunctionalInterface
public interface SqlPageDoing<T> extends BaseDoing<T> {
    default PageResult<T> go(PagerInfo pagerInfo, Logger log) {
        PageResult pageResult = new PageResult(pagerInfo.getPageNo(), pagerInfo.getPageSize());
        this.service(pageResult);
        if (null == pageResult.list) {
            pageResult.list = Lists.newArrayList();
        }
        if (null == pageResult.totalCount) {
            pageResult.totalCount = 0;
        }
        pageResult.totalPage = pageResult.totalCount == 0 ? 0 : pageResult.totalCount / pageResult.pageSize + 1;
        return pageResult;
    }

    void service(PageResult pageResult);
}
