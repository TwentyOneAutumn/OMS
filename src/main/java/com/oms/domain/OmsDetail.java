package com.oms.domain;


import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("oms_detail")
@KeySequence("UUIDKeyGenerator")
public class OmsDetail  extends BaseEntitys implements Serializable {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 疫苗表ID
     */
    private String vaccineId;

    /**
     * 交易表ID
     */
    private String transactionId;

    /**
     * 饲养表ID
     */
    private String feedingId;

    /**
     * 品种
     */
    private String variety;

    /**
     * 来源
     */
    private String source;

    /**
     * 入库时间
     */
    private LocalDate startTime;

    /**
     * 出库时间
     */
    private LocalDate endTime;
}
