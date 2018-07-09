package com.zlinks.common;

import com.zlinks.common.constants.BaseResultCodeConstant;
import com.zlinks.common.constants.CommonConstant;
import com.zlinks.common.web.JsonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangjh on 2017/10/10.
 */
public interface BaseDoing<T> {

    static String order_by = "order by";
    static String limit_offset = " limit :offset,:size";
    static String showSqlformat = "======================>{} : {}";
    static String dataSqlName = "dataSql";
    static String countSqlName = "countSql";
    static String sqlSpendformat = "className:{}, method:{},spend {} ms";
    static String offset = "offset";
    static String size = "size";
    static String countField = "count(1)";

    /**
     * @param e
     * @param log
     */
    default void showErrorLog(Exception e, Logger log) {
        this.showErrorLog(null, e, log);
    }

    /**
     * @param jr
     * @param e
     * @param log
     */
    default void showErrorLog(JsonResult jr, Exception e, Logger log) {
        if (jr != null) {
            jr.saveResult(BaseResultCodeConstant.FAILED.getCode(), log);
        }
        log.error(e.getMessage(), e);
    }




    default void errorLog(Logger log, Exception e) {
        log.error(e.getMessage(), e);
    }

    default void showSql(Map<String, Object> params, String sqlName, String sql, Logger log) {
        // 输出 sql
        Set<String> paramsKeys = params.keySet();
        Iterator<String> keys = paramsKeys.iterator();
        if (paramsKeys != null && paramsKeys.size() > 0) {
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = params.get(key);
                if (value != null) {
                    sql = sql.replace(CommonConstant.COLON + key, value.toString());
                }
            }
            log.info(showSqlformat, sqlName, sql);
        }
    }


}
