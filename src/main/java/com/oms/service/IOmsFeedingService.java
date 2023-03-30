package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsFeeding;
import com.oms.domain.Row;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;

import java.util.List;

/**
 * 饲养Service
 */
public interface IOmsFeedingService extends IService<OmsFeeding> {

    /**
     * 根据条件查询列表
     *
     * @return TableInfo
     */
    List<FeedingListVo> toList();

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    Row<FeedingDetailVo> toDetail(FeedingDetailDto dto);

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toAdd(FeedingAddDto dto);

    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toEdit(FeedingEditDto dto);

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toDelete(FeedingDeleteDto dto);
}
