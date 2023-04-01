package com.oms.domain.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VaccineAddDto {

    /**
     * 批次
     */
    private Integer batchNum;

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

    /**
     * 负责人名称
     */
    private String responsiblePersonName;
}
