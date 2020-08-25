package cn.microservice.www.controller;

import cn.microservice.www.common.Result;
import cn.microservice.www.enums.GlobalExceptionEnum;
import cn.microservice.www.exception.GlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理类
 * @author MachineGeek
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 统一异常处理
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleException(HttpServletResponse httpServletResponse, Exception exception){
        if(exception instanceof GlobalException){
            GlobalException globalException = (GlobalException) exception;
            return Result.exception(globalException.getGlobalExceptionEnum());
        }
        return Result.exception(GlobalExceptionEnum.UNKNOW_EXCEPTION);
    }
}
