package cn.microservice.www.dto;

import lombok.Data;

/**
 * 分页请求参数
 * @author MachineGeek
 */
@Data
public class PageDto {
    private int page;
    private int size;
    private String keyWord;
}
