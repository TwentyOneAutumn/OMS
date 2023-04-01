package com.oms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("oms_vaccine")
@KeySequence("UUIDKeyGenerator")
@EqualsAndHashCode(callSuper = true)
public class OmsVaccine  extends BaseEntitys implements Serializable {

    /**
     * 主键ID
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 详情ID
     */
    private String detailId;

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
     * 负责人ID
     */
    private String responsiblePersonId;

    /**
     * 负责人名称
     */
    private String responsiblePersonName;
}
