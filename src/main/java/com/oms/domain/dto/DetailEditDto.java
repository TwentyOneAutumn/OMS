package com.oms.domain.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class DetailEditDto {

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
     * 出库时间
     */
    private LocalDate endTime;

}

