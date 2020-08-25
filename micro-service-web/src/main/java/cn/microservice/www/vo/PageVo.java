package cn.microservice.www.vo;

import lombok.Data;

/**
 * 分页结果类
 * @author MachineGeek
 */
@Data
public class PageVo {
    private int total;
    private Object data;
}
