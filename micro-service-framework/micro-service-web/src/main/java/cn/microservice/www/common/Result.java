package cn.microservice.www.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 结果返回类
 * @author MachineGeek
 */
@Data
@AllArgsConstructor
public class Result<T>{
    private int code;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String msg;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T data;

    /**
     * 成功常量
     */
    private static final Result SUCCESS = new Result(Constant.SUCCESS,null,null);

    public static Result ok(){
        return SUCCESS;
    }

    /**
     * 返回成功结果
     * @return
     */
    public static <T> Result<T> ok(T data){
        return new Result<T>(Constant.SUCCESS,"success",data);
    }

    /**
     * 返回失败信息
     * @param msg
     * @return
     */
    public static Result fail(String msg){
        return new Result(Constant.FAIL,msg,null);
    }
}
