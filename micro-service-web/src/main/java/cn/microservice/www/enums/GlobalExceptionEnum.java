package cn.microservice.www.enums;

/**
 * 全局异常枚举类
 * @author MachineGeek
 */
public enum GlobalExceptionEnum {

    /**
     * 未知错误
     */
    UNKNOW_EXCEPTION(10001,"未知错误")

    ;
    private int code;
    private String msg;

    GlobalExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
