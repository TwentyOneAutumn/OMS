package com.oms.domain.dto;

import lombok.Data;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Data
public class FeedingEditDto {
    @NotBlank(message = "id参数不能为空")
    private String id;
}
