package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsTransaction;
import com.oms.domain.Row;
import com.oms.domain.TableInfo;
import com.oms.domain.dto.*;
import com.oms.domain.vo.TransactionDetailVo;
import com.oms.domain.vo.TransactionListVo;

import java.util.List;

/**
 * 交易Service
 */
public interface IOmsTransactionService extends IService<OmsTransaction> {

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    TableInfo<TransactionListVo> toList(TransactionListDto dto);

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    Row<TransactionDetailVo> toDetail(TransactionDetailDto dto);

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toAdd(TransactionAddDto dto);

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    AjaxResult toDelete(TransactionDeleteDto dto);
}
