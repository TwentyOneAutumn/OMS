package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsVaccine;
import com.oms.domain.Row;
import com.oms.domain.TableInfo;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;

import java.util.List;

/**
 * 疫苗Service
 */
public interface IOmsVaccineService extends IService<OmsVaccine> {

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    TableInfo<VaccineListVo> toList(VaccineListDto dto);

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    Row<VaccineDetailVo> toDetail(VaccineDetailDto dto);

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toAdd(VaccineAddDto dto);

    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toEdit(VaccineEditDto dto);

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toDelete(VaccineDeleteDto dto);
}
