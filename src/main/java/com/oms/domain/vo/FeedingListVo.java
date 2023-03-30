package com.oms.domain.vo;

import lombok.Data;

@Data
public class FeedingListVo {

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
     * 饲养频率
     */
    private String feedingFrequency;

    /**
     * 饲料类型
     */
    private String fodderType;

    /**
     * 负责人ID
     */
    private String responsiblePersonId;

    /**
     * 负责人名称
     */
    private String responsiblePersonName;
}
