package com.oms.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("oms_user")
@KeySequence("UUIDKeyGenerator")
@EqualsAndHashCode(callSuper = true)
public class OmsUser extends BaseEntitys implements Serializable {

    /**
     * 主键ID
     */
    @TableId(type = IdType.INPUT)
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private Boolean role;
}


