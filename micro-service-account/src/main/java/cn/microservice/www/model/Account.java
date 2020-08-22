package cn.microservice.www.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 账户类
 * @author MachineGeek
 */
@Data
public class Account {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long id;
    private String picture;
    private String name;
    private String password;
    private String nickname;
    private int gender;
    private String remark;
}
