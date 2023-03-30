package com.oms.domain.dto;

import lombok.Data;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Data
public class FeedingEditDto {
    @NotBlank(message = "id参数不能为空")
    private String id;

    /**
     * 饲养频率
     */
    @NotBlank(message = "feedingFrequency参数不能为空")
    private String feedingFrequency;

    /**
     * 饲料类型
     */
    @NotBlank(message = "fodderType参数不能为空")
    private String fodderType;
}
