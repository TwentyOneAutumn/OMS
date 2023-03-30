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
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("oms_transaction")
@KeySequence("UUIDKeyGenerator")
@EqualsAndHashCode(callSuper = true)
public class OmsTransaction extends BaseEntitys implements Serializable {

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
     * 交易数量
     */
    private Integer transactionNumber;

    /**
     * 交易价格
     */
    private Integer transactionPrice;

    /**
     * 交易时间
     */
    private LocalDateTime transactionTime;

    /**
     * 负责人ID
     */
    private String responsiblePersonId;

    /**
     * 负责人名称
     */
    private String responsiblePersonName;
}
