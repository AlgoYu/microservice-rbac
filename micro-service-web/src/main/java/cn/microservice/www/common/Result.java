package cn.microservice.www.common;

import cn.microservice.www.enums.GlobalExceptionEnum;
import cn.microservice.www.exception.GlobalException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回类
 * @author MachineGeek
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private boolean ok;
    private int code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public static Result ok(){
        return new Result(true,200,"Success",null);
    }

    public static Result success(Object data){
        return new Result(true,200,"Success",data);
    }

    public static Result fail(String message){
        return new Result(false,200,message,null);
    }

    public static Result exception(GlobalExceptionEnum globalExceptionEnum){
        return new Result(false,globalExceptionEnum.getCode(),globalExceptionEnum.getMsg(),null);
    }
}
