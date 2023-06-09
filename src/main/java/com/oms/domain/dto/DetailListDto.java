package com.oms.domain.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class DetailListDto {
    private String variety;
    private String source;
    @NotNull(message = "isVaccine参数不能为空")
    private Boolean isVaccine;
    @NotNull(message = "pageSize参数不能为空")
    private Integer pageSize;
    @NotNull(message = "pageNum参数不能为空")
    private Integer pageNum;
}
