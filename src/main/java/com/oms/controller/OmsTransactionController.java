package com.oms.controller;

import com.oms.domain.AjaxResult;
import com.oms.domain.Row;
import com.oms.domain.TableInfo;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;
import com.oms.service.IOmsTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 交易Controller
 */
@RestController
@RequestMapping("/transaction")
public class OmsTransactionController {

    @Autowired
    private IOmsTransactionService TransactionService;

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @GetMapping("/list")
    public TableInfo<TransactionListVo> toList(@Valid TransactionListDto dto){
        return TransactionService.toList(dto);
    }

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @GetMapping("/detail")
    public Row<TransactionDetailVo> toDetail(@Valid TransactionDetailDto dto){
        return TransactionService.toDetail(dto);
    }

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @PostMapping("/add")
    public AjaxResult toAdd(@Valid @RequestBody TransactionAddDto dto){
        return TransactionService.toAdd(dto);
    }

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @DeleteMapping("/delete")
    public AjaxResult toDelete(@Valid @RequestBody TransactionDeleteDto dto){
        return TransactionService.toDelete(dto);
    }
}
