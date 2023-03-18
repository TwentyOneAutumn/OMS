package com.oms.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginCheckDto {
    @NotBlank(message = "loginId参数不能为空")
    private String loginId;
    @NotBlank(message = "password参数不能为空")
    private String password;
}
