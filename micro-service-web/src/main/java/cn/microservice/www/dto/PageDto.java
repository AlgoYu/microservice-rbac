package cn.microservice.www.dto;

import lombok.Data;

/**
 * 分页查询请求参数类
 * @author MachineGeek
 */
@Data
public class PageDto {
    private String keyWord;
    private int page;
    private int size;
}
