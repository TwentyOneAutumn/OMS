package com.oms.domain.dto;

import lombok.Data;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Data
public class FeedingAddDto {

    /**
     * 批次
     */
    @NotBlank(message = "batchNum参数不能为空")
    private Integer batchNum;

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

    /**
     * 负责人名称
     */
    @NotBlank(message = "responsiblePersonName参数不能为空")
    private String responsiblePersonName;
}
