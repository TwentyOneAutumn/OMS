package com.oms.domain.dto;

import lombok.Data;

@Data
public class UserAddDto {

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
}
