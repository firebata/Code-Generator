package com.zlinks.common.exception;

import com.zlinks.common.constants.BaseResultCodeConstant;
import com.zlinks.common.web.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author zhangjh
 * @date 2017/10/31 15:39
 */
@ControllerAdvice
public class CommonExceptionHandler {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 异常处理方法：
     * 根据特定的异常返回指定的 HTTP 状态码
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public JsonResult handleValidationException(ConstraintViolationException ex) {
        logger.error(ex.getMessage(), ex);
        Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : errors) {
            strBuilder.append(violation.getMessage() + "\n");
        }
        return new JsonResult().build(BaseResultCodeConstant.FAILED.getCode(), strBuilder.toString());
    }

    /**
     * 通用异常的处理，返回500
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public JsonResult handleBusinessException(BusinessException ex) {
        logger.error(ex.getMessage(), ex);
        return new JsonResult().build(ex.getCode(), ex.getMessage());
    }

    /**
     * 通用异常的处理，返回500
     *
     * @param ex
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult handleException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return new JsonResult().build(BaseResultCodeConstant.FAILED.getCode(), ex.getMessage());
    }
}
