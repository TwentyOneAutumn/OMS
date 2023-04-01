package com.oms.domain.vo;

import lombok.Data;
import java.time.LocalDate;

@Data
public class VaccineListVo {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 详情ID
     */
    private String detailId;

    /**
     * 批次
     */
    private Integer batchNum;

    /**
     * 品种
     */
    private String variety;

    /**
     * 来源
     */
    private String source;

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
