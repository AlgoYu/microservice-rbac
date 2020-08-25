package cn.microservice.www.exception;

import cn.microservice.www.enums.GlobalExceptionEnum;
import lombok.Data;

/**
 * 全局异常类
 * @author MachineGeek
 */
@Data
public class GlobalException extends RuntimeException{
    private GlobalExceptionEnum globalExceptionEnum;

    public GlobalException(GlobalExceptionEnum globalExceptionEnum) {
        this.globalExceptionEnum = globalExceptionEnum;
    }
}