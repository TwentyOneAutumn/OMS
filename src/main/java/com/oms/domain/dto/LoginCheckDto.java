package com.oms.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginCheckDto {
    @NotBlank(message = "account参数不能为空")
    private String account;
    @NotBlank(message = "password参数不能为空")
    private String password;
}
