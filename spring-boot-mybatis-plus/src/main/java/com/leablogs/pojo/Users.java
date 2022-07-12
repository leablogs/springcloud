package com.leablogs.pojo;
import com.baomidou.mybatisplus.annotation.*;

@TableName("sys_users")
public class Users {
    @TableId
    @OrderBy
    private Long id;
    @TableField("nickname")
    @Version
    private String name;
    private Integer age;
    private String email;
    @TableLogic(delval = "1", value = "0")
    private String is_del;
}
