package com.oms.domain.dto;

import lombok.Data;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.time.LocalDate;

@Data
public class VaccineEditDto {
    @NotBlank(message = "id参数不能为空")
    private String id;

    /**
     * 疫苗名称
     */
    private String vaccineName;

    /**
     * 疫苗类型
     */
    private String vaccineType;

    /**
     * 疫苗价格
     */
    private Integer vaccinePrice;

    /**
     * 注射时间
     */
    private LocalDate injectTime;
}
