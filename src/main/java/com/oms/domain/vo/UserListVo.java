package com.oms.domain.vo;

import lombok.Data;

@Data
public class UserListVo {

    /**
     * 主键ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;
}
