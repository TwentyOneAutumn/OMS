package com.oms.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionAddDto {

    /**
     * 批次
     */
    private Integer batchNum;

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
     * 负责人名称
     */
    private String responsiblePersonName;
}
