package cn.microservice.www.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 权限类
 * @author MachineGeek
 */
@Data
public class Permission {
    @TableId(type = IdType.ASSIGN_ID)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String remark;
    private Integer enable;
    @Version
    private Integer version;
    private Integer delete;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
