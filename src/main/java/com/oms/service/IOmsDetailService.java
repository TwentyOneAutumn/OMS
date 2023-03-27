package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.domain.*;
import com.oms.domain.dto.*;
import com.oms.domain.vo.DetailDetailVo;
import com.oms.domain.vo.DetailListVo;

import java.util.List;

/**
 * 养殖明细Service
 */
public interface IOmsDetailService extends IService<OmsDetail> {

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    TableInfo<DetailListVo> toList(DetailListDto dto);

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    Row<DetailDetailVo> toDetail(DetailDetailDto dto);

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toAdd(DetailAddDto dto);

    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toEdit(DetailEditDto dto);

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toDelete(DetailDeleteDto dto);
}
