package com.oms.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionListVo {

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
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone ="GMT+8")
    private LocalDateTime transactionTime;

    /**
     * 负责人名称
     */
    private String responsiblePersonName;
}
