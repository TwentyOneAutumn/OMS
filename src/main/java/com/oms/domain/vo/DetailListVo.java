package com.oms.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class DetailListVo implements Serializable {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 品种
     */
    private String variety;

    /**
     * 来源
     */
    private String source;

    /**
     * 购买价格
     */
    private Integer buyingPrice;

    /**
     * 是否接种疫苗
     */
    private Boolean isVaccine;

    /**
     * 饲养情况
     */
    private Boolean isFeeding;

    /**
     * 入库时间
     */
    private LocalDate startTime;
}
