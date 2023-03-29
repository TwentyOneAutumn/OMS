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
@TableName("oms_feeding")
@KeySequence("UUIDKeyGenerator")
@EqualsAndHashCode(callSuper = true)
public class OmsFeeding extends BaseEntitys implements Serializable {

    /**
     * 主键ID
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 品种
     */
    private String variety;

    /**
     * 饲养频率
     */
    private String feedingFrequency;

    /**
     * 饲料类型
     */
    private String fodderType;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 负责人ID
     */
    private String responsiblePersonId;

    /**
     * 负责人名称
     */
    private String responsiblePersonName;
}
