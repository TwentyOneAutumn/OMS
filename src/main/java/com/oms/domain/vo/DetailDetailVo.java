package com.oms.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class DetailDetailVo {
    /**
     * 主键ID
     */
    private String id;

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
     * 入库时间
     */
    private LocalDate startTime;

    /**
     * 出库时间
     */
    private LocalDate endTime;
}
