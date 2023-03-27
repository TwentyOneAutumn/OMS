package com.oms.domain.dto;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class DetailAddDto implements Serializable {

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
