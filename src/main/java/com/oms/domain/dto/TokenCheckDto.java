package com.oms.domain.dto;

import lombok.Data;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Data
public class TokenCheckDto {
    @NotBlank(message = "token参数不能为空")
    private String token;
    @NotBlank(message = "account参数不能为空")
    private String account;
}
