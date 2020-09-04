package cn.microservice.www.common;

import lombok.Data;

import java.util.List;

/**
 * 分页类
 * @author MachineGeek
 */
@Data
public class Page<T> {
    private Long total;
    private List<T> list;
}
