package com.oms.domain;

//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.KeySequence;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;


@Data
//@TableName("sys_user")
//@KeySequence("")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntitys implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
//    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 账号
     */
    private String loginId;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 年龄
     */
    private int age;

    /**
     * 生日
     */
    private LocalDate birthday;
}


