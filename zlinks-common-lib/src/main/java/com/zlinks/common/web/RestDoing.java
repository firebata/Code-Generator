package com.zlinks.common.web;

import com.zlinks.common.constants.BaseResultCodeConstant;
import com.zlinks.common.exception.BusinessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by zhangjh on 2017/10/10.
 */
@FunctionalInterface
public interface RestDoing<T> {
    Logger log = LoggerFactory.getLogger(RestDoing.class);
    String sqlReturnFormat = "======================>return data : {}";

    default JsonResult<T> go(Logger log) {
        return this.invoke(null, null, null, null, log);
    }

    default JsonResult<T> go(HttpServletRequest r, Logger log) {
        return this.invoke(null, null, r, null, log);
    }

    default JsonResult<T> go(HttpServletRequest r, ObjectMapper objectMapper, Logger log) {
        return this.invoke(null, null, r, objectMapper, log);
    }

    default JsonResult<T> go(Object visitor, HttpServletRequest request, ObjectMapper objectMapper, Logger log) {
        return this.invoke(null, visitor, request, objectMapper, log);
    }

    default JsonResult<T> go(Object inputData, Object visitor, HttpServletRequest request, ObjectMapper objectMapper, Logger log) {
        return this.invoke(inputData, visitor, request, objectMapper, log);
    }

    default JsonResult<T> invoke(Object inputData, Object visitor, HttpServletRequest request, ObjectMapper objectMapper, Logger log) {
        JsonResult<T> jr = new JsonResult();
        try {
            this.service(jr);
        } catch (BusinessException e) {
            //TODO 事务回滚
            log.error("error happen:{}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            jr.errorParam(e.getCode(), e.desc, log);
        } catch (Exception e) {
            //TODO 事务回滚
            log.error("error happen:{}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            jr.saveResult(BaseResultCodeConstant.FAILED.getCode(), log);
        } finally {
            this.showReturnData(jr, objectMapper, log);
            LocalDateTime arrivalDate = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
            String timestamp = arrivalDate.format(format);
            jr.setTimestamp(timestamp);
        }
        return jr;
    }

    /**
     * @param jr
     * @param objectMapper
     * @param log
     */
    default void showReturnData(JsonResult jr, ObjectMapper objectMapper, Logger log) {
        if (objectMapper != null) {
            try {
                String returnData = objectMapper.writeValueAsString(jr);
                log.warn(sqlReturnFormat, returnData);
            } catch (JsonProcessingException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    void service(JsonResult<T> jsonResult) throws Exception;
}
