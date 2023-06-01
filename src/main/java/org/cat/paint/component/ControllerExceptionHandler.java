package org.cat.paint.component;

import lombok.extern.slf4j.Slf4j;
import org.cat.paint.beans.vo.Result;
import org.cat.paint.enums.RespCode;
import org.cat.paint.exception.BusinessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhangpeng
 * @description
 * @date 2023/6/1 10:47
 **/
@Slf4j
@Component
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(RuntimeException e){
        e.printStackTrace();
        Result<?> result = new Result<>();
        if(e instanceof BusinessException){
            result.setCode(((BusinessException) e).getCode());
            result.setMsg(e.getMessage());
        }else{
            result.setCode(RespCode.FAILED.getCode());
            result.setMsg(e.getMessage());
        }
        return result;
    }

}
